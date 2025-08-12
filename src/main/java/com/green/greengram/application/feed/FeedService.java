package com.green.greengram.application.feed;

import com.green.greengram.application.feed.model.FeedGetDto;
import com.green.greengram.application.feed.model.FeedGetRes;
import com.green.greengram.application.feed.model.FeedPostReq;
import com.green.greengram.application.feed.model.FeedPostRes;
import com.green.greengram.application.feedcomment.FeedCommentMapper;
import com.green.greengram.application.feedcomment.model.FeedCommentGetReq;
import com.green.greengram.application.feedcomment.model.FeedCommentGetRes;
import com.green.greengram.application.feedcomment.model.FeedCommentItem;
import com.green.greengram.config.util.ImgUploadManager;
import com.green.greengram.entity.Feed;
import com.green.greengram.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper feedMapper;
    private final FeedCommentMapper feedCommentMapper;
    private final FeedRepository feedRepository;
    private final ImgUploadManager imgUploadManager;

    @Transactional
    public FeedPostRes postFeed(long signedUserId, FeedPostReq req, List<MultipartFile> pics) {
        User writerUser = new User();
        writerUser.setUserId(signedUserId);

        Feed feed = Feed.builder()
                .writerUser(writerUser)
                .location(req.getLocation())
                .contents(req.getContents())
                .build();

        feedRepository.save(feed); //feed객체는 영속성을 갖는다.

        List<String> fileNames = imgUploadManager.saveFeedPics(feed.getFeedId(), pics);

        feed.addFeedPics(fileNames);

        return new FeedPostRes(feed.getFeedId(), fileNames);
    }

    public List<FeedGetRes> getFeedList(FeedGetDto dto) {
        List<FeedGetRes> list = feedMapper.findAllLimitedTo(dto);
        for (FeedGetRes feedGetRes : list) {
            // 해당 피드 사진 리스트 세팅
            feedGetRes.setPics(feedMapper.findAllPicByFeedId(feedGetRes.getFeedId()));

            // 해당 피드 댓글 4개 세팅
            FeedCommentGetReq commentReq = new FeedCommentGetReq(feedGetRes.getFeedId(), 0, 4);
            List<FeedCommentItem> commentList = feedCommentMapper.findAllByFeedIdLimitedTo(commentReq);

            boolean moreComment = commentList.size() > 3;

            // 댓글이 4개 이상이면 마지막 댓글을 삭제
            if (moreComment) {
                commentList.remove(commentList.size() - 1);  // 마지막 댓글 제거
            }

            FeedCommentGetRes feedCommentGetRes = new FeedCommentGetRes(moreComment, commentList);
            feedGetRes.setComments(feedCommentGetRes);
        }
        return list;
    }
}
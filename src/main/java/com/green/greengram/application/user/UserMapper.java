package com.green.greengram.application.user;


import com.green.greengram.application.feed.model.FeedGetDto;
import com.green.greengram.application.feed.model.FeedGetRes;
import com.green.greengram.application.user.model.UserProfileGetDto;
import com.green.greengram.application.user.model.UserProfileGetRes;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {
    List<FeedGetRes> selectUserLikedFeedList(FeedGetDto dto);
    UserProfileGetRes findProfileByUserId(UserProfileGetDto dto);
}
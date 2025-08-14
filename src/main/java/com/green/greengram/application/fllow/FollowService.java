package com.green.greengram.application.fllow;

import com.green.greengram.application.feed.FeedRepository;
import com.green.greengram.application.feedlike.FeedLikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Service
@RequiredArgsConstructor
public class FollowService {
    private final FeedRepository feedRepository;
}

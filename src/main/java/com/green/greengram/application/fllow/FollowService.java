package com.green.greengram.application.fllow;

import com.green.greengram.application.user.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FollowService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;


    public FollowService(FollowRepository followRepository, UserRepository userRepository) {
        this.followRepository = followRepository;
        this.userRepository = userRepository;
    }

    public void postUserFollow(Long fromUserId, Long toUserId) {
        // 1. 팔로우 대상 유저 존재 여부 체크
        // 2. 본인이 본인을 팔로우 하는지 체크
        // 3. 이미 팔로우 하고 있는지 체크 (중복 방지)
        // 4. 팔로우 엔티티 생성 후 저장
    }
}

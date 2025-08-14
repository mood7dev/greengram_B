package com.green.greengram.application.user;


import com.green.greengram.application.feed.model.FeedGetDto;
import com.green.greengram.application.feed.model.FeedGetRes;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {
    List<FeedGetRes> findProfileByUserId(FeedGetDto dto);
}
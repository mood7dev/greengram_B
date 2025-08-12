package com.green.greengram.application.feedcomment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedCommentGetReq {
    private long feedId;
    private int startIdx;
    private int size;
}

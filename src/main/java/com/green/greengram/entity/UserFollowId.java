package com.green.greengram.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserFollowId implements Serializable {
    private Long fromUser;
    private Long toUser;

    public UserFollowId() {}

    public UserFollowId(Long fromUser, Long toUser) {
        this.fromUser = fromUser;
        this.toUser = toUser;
    }
}

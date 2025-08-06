package com.green.greengram.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@IdClass(UserFollowId.class)
public class UserFollow extends CreatedAt{

    @Id
    @ManyToOne
    @JoinColumn(name = "from_user_id", referencedColumnName = "id", nullable = false)
    private User fromUser;

    @Id
    @ManyToOne
    @JoinColumn(name = "to_user_id", referencedColumnName = "id", nullable = false)
    private User toUser;
}

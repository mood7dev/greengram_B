package com.green.greengram.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class FeedPicIds implements Serializable {
    private Long feedId;
    @Column(nullable = false, length = 50)
    private String pic;
}


package com.green.greengram.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class FeedLike extends CreatedAt{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;
}

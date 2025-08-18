package com.green.greengram.application.feedlike;

import com.green.greengram.entity.FeedLike;
import com.green.greengram.entity.FeedLikeIds;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;


@Repository
public interface FeedLikeRepository extends JpaRepository<FeedLike, FeedLikeIds> {
    @Modifying
    @Transactional
    void deleteByIdFeedId(Long feedId);
}
package com.green.greengram.application.feedcomment;
import com.green.greengram.entity.FeedComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FeedCommentRepository extends JpaRepository<FeedComment, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM FeedComment fc WHERE fc.feed.feedId = :feedId")
    void deleteByFeedFeedId(Long feedId);
}
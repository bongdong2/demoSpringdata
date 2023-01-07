package me.seungui.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository extends MyRepository<Comment, Long> {
    Page<Comment> findByTitleContainsIgnoreCaseAndLikeCountGreaterThan(String title, int likeCount, Pageable pageable);
}

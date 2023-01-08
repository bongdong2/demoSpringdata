package me.seungui.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

public interface CommentRepository extends MyRepository<Comment, Long> {
    //Page<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String title, int likeCount, Pageable pageable);

    @Async
    Future<Page<Comment>> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String title, int likeCount, Pageable pageable);
}

package me.seungui.demospringdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;


    @Test
    void CommentTest() {
        createComments("Hello Title", 3);
        createComments("Hello Title22", 1);
        createComments("Hello Title3333", 999);
        createComments("Hello 4444", 3333);
        createComments("Hello 5555555", 9090);

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("likeCount").descending());
        //Page<Comment> comments = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("LLO", 10, pageRequest);
        //assertEquals(3, comments.getContent().size());
    }

    @Test
    void asyncFuture() throws ExecutionException, InterruptedException {
        createComments("Hello Title", 3);
        createComments("Hello Title22", 1);
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("likeCount").descending());
        Future<Page<Comment>> future = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("LLO", 10, pageRequest);
        Page<Comment> comments = future.get();
    }

    private void createComments(String comment, int likeCount) {
        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setLikeCount(likeCount);
        commentRepository.save(newComment);
    }
}
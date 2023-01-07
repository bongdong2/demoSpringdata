package me.seungui.demospringdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
        Page<Comment> comments = commentRepository.findByTitleContainsIgnoreCaseAndLikeCountGreaterThan("LLO", 10, pageRequest);
        assertEquals(3, comments.getContent().size());
    }

    private void createComments(String title, int likeCount) {
        Comment comment = new Comment();
        comment.setTitle(title);
        comment.setLikeCount(likeCount);
        commentRepository.save(comment);
    }
}
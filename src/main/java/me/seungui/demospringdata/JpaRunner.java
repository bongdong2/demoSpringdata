package me.seungui.demospringdata;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

  @Autowired
  PostRepository postRepository;

  @Override
  public void run(ApplicationArguments args) {
    Post post = new Post();
    post.setTitle("title");
    postRepository.save(post);
  }
}






















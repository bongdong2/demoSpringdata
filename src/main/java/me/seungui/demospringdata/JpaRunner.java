package me.seungui.demospringdata;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public void run(ApplicationArguments args) {
    // Dirty checking : 객체의 상태변화 감지
    // Write Behind : 객체의 상태변화를 데이터베이스에 최대한 늦게 반영

    // JQPL : 테이블이 아닌 엔티티 객체 모델 기반으로 쿼리 작성
//    TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);
//    List<Post> posts = query.getResultList();
//    posts.forEach(System.out::println);

    // Criteria
//    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//    CriteriaQuery<Post> query = builder.createQuery(Post.class);
//    Root<Post> root = query.from(Post.class);
//    query.select(root);
//
//    List<Post> posts = entityManager.createQuery(query).getResultList();
//    posts.forEach(System.out::println);

    // Native
    List<Post> posts = entityManager.createNativeQuery("select * from post", Post.class).getResultList();
    posts.forEach(System.out::println);
  }
}






















package me.seungui.demospringdata;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.hibernate.Session;
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
    Account account = new Account();
    account.setUsername("seungui");
    account.setPassword("1q2w3e4r5t!");

    Study study = new Study();
    study.setName("Spring data JPA");
    study.setAccount(account);
    account.addStudy(study);

    Session session = entityManager.unwrap(Session.class);
    session.save(account);
    session.save(study);

    Account seungui = session.load(Account.class, account.getId());
    // Dirty checking : 객체의 상태변화 감지
    // Write Behind : 객체의 상태변화를 데이터베이스에 최대한 늦게 반영
    seungui.setUsername("bongdong2");
    System.out.println("=================");
  }
}

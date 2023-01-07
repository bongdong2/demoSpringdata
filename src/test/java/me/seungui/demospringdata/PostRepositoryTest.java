package me.seungui.demospringdata;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PostRepositoryTest {

    @Test
    public void postTest() {
        System.out.println("hello world");
    }
}
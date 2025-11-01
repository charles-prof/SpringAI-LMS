package com.springailms.games.repository;

import com.springailms.games.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldSaveAndFindUserByEmail() {
        // given
        User user = User.builder()
                .email("student@example.com")
                .password("secret")
                .role(Role.STUDENT)
                .plan(Plan.FREE)
                .build();

        userRepository.save(user);

        // when
        User found = userRepository.findByEmail("student@example.com");

        // then
        assertThat(found).isNotNull();
        assertThat(found.getEmail()).isEqualTo("student@example.com");
        assertThat(found.getRole()).isEqualTo(Role.STUDENT);
    }
}

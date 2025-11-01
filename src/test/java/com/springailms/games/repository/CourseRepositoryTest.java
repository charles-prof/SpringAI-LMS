package com.springailms.games.repository;

import com.springailms.games.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void shouldFindCoursesByInstructorId() {
        // given
        Course course = Course.builder()
                .title("Spring Boot Basics")
                .description("Learn Spring Boot fast")
                .instructorId(1L)
                .publishState(PublishState.PUBLISHED)
                .build();

        courseRepository.save(course);

        // when
        List<Course> courses = courseRepository.findByInstructorId(1L);

        // then
        assertThat(courses).isNotEmpty();
        assertThat(courses.get(0).getTitle()).isEqualTo("Spring Boot Basics");
    }
}

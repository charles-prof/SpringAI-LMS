package com.springailms.games.repository;

import com.springailms.games.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EnrollmentRepositoryTest {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void shouldSaveAndFindEnrollmentsByStudentId() {
        // given
        User student = userRepository.save(
                User.builder()
                        .email("student1@example.com")
                        .password("pwd")
                        .role(Role.STUDENT)
                        .plan(Plan.PRO)
                        .build()
        );

        User instructor = userRepository.save(
                User.builder()
                        .email("instructor@example.com")
                        .password("pwd")
                        .role(Role.INSTRUCTOR)
                        .plan(Plan.INSTRUCTOR)
                        .build()
        );

        Course course = courseRepository.save(
                Course.builder()
                        .title("Spring Boot Advanced")
                        .description("Deep dive into Spring Boot")
                        .instructorId(instructor.getId())
                        .publishState(PublishState.PUBLISHED)
                        .build()
        );

        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .course(course)
                .progress(75)
                .completed(false)
                .enrolledAt(LocalDate.now())
                .build();

        enrollmentRepository.save(enrollment);

        // when
        List<Enrollment> found = enrollmentRepository.findByStudentId(student.getId());

        // then
        assertThat(found).isNotEmpty();
        assertThat(found.get(0).getCourse().getTitle()).isEqualTo("Spring Boot Advanced");
    }
}

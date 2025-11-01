package com.springailms.games.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many enrollments belong to one student
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    // Many enrollments belong to one course
    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(nullable = false)
    @Builder.Default
    private int progress = 0; // 0 to 100

    @Column(nullable = false)
    @Builder.Default
    private boolean completed = false;

    private LocalDate enrolledAt;
    private LocalDate completedAt;
}

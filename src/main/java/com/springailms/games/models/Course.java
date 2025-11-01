package com.springailms.games.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Long instructorId;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private PublishState publishState = PublishState.DRAFT;
}


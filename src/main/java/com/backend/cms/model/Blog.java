package com.backend.cms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "blog")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String text;

    @Column
    private LocalDateTime post_date;
}

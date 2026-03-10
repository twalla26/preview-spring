package org.study.previewspring.questionlist.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Builder
    public Category(String name) {
        this.name = name;
    }

}
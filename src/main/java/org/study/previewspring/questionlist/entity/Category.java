package org.study.previewspring.questionlist.entity;

import jakarta.persistence.*;
import lombok.*;
import org.study.previewspring.user.entity.UserQuestionList;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "questionList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionListCategory> questionListCategories = new ArrayList<>();

    private Category(String name) {
        this.name = name;
    }

    public static Category create(String name) {
        return new Category(name);
    }

}
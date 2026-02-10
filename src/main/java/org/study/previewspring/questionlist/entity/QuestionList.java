package org.study.previewspring.questionlist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.study.previewspring.user.User;
import org.study.previewspring.user.UserQuestionList;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "question_list")
public class QuestionList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "is_public", nullable = false, columnDefinition = "TINYINT")
    private Boolean isPublic;

    @ColumnDefault("0")
    @Column(name = "`usage`", nullable = false)
    private Integer usage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "questionList")
    private Set<Question> questions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "questionList", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserQuestionList> scrappedByUsers = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "question_list_category",
            joinColumns = @JoinColumn(name = "question_list_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new LinkedHashSet<>();
}
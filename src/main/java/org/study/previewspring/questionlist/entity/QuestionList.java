package org.study.previewspring.questionlist.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.study.previewspring.user.entity.User;
import org.study.previewspring.user.entity.UserQuestionList;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "question_list")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private Integer usage = 0;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "questionList")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "questionList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserQuestionList> scrappedByUsers = new ArrayList<>();

    @Builder(access = AccessLevel.PRIVATE)
    private QuestionList(String title, Boolean isPublic, User user) {
        this.title = title;
        this.isPublic = isPublic;
        this.user = user;
    }

    public static QuestionList create(String title, Boolean isPublic, User user) {
        return QuestionList.builder()
                .title(title)
                .isPublic(isPublic)
                .user(user)
                .build();
    }

}
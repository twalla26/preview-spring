package org.study.previewspring.questionlist.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@Table(name = "question")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "`index`", nullable = false)
    private Integer index;

    @Column(name = "content", nullable = false, length = 200)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "question_list_id", nullable = false)
    private QuestionList questionList;

    @Builder
    public Question(Integer index, String content, QuestionList questionList) {
        this.index = index;
        this.content = content;
        this.questionList = questionList;
    }

}
package org.study.previewspring.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.study.previewspring.questionlist.entity.QuestionList;

@Getter
@Setter
@Entity
@Table(name = "user_question_list")
public class UserQuestionList {
    @EmbeddedId
    private UserQuestionListId id = new UserQuestionListId();

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @MapsId("questionListId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "question_list_id", nullable = false)
    private QuestionList questionList;

}
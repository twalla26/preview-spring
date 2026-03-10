package org.study.previewspring.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.study.previewspring.questionlist.entity.QuestionList;

@Getter
@Entity
@Table(name = "user_question_list")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Builder(access = AccessLevel.PRIVATE)
    private UserQuestionList(User user, QuestionList questionList) {
        this.user = user;
        this.questionList = questionList;
        this.id = UserQuestionListId.of(user.getId(), questionList.getId());
    }

    public static UserQuestionList create(User user, QuestionList questionList) {
        return UserQuestionList.builder()
                .user(user)
                .questionList(questionList)
                .build();
    }

}
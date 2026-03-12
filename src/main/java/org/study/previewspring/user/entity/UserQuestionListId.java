package org.study.previewspring.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class UserQuestionListId implements Serializable {
    private static final long serialVersionUID = -712526965888653335L;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "question_list_id", nullable = false)
    private Integer questionListId;

    private UserQuestionListId(Integer userId, Integer questionListId) {
        this.userId = userId;
        this.questionListId = questionListId;
    }

    public static UserQuestionListId of(Integer userId, Integer questionListId) {
        return new UserQuestionListId(userId, questionListId);
    }

}
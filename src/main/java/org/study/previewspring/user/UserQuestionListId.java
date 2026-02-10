package org.study.previewspring.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UserQuestionListId implements Serializable {
    private static final long serialVersionUID = -712526965888653335L;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "question_list_id", nullable = false)
    private Integer questionListId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserQuestionListId entity = (UserQuestionListId) o;
        return Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.questionListId, entity.questionListId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, questionListId);
    }

}
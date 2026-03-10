package org.study.previewspring.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class UserQuestionListId implements Serializable {
    private static final long serialVersionUID = -712526965888653335L;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "question_list_id", nullable = false)
    private Integer questionListId;

}
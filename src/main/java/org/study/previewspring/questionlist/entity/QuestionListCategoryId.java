package org.study.previewspring.questionlist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class QuestionListCategoryId implements Serializable {
    private static final long serialVersionUID = 4923236846156054482L;
    @Column(name = "question_list_id", nullable = false)
    private Integer questionListId;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    private QuestionListCategoryId(Integer questionListId, Integer categoryId) {
        this.questionListId = questionListId;
        this.categoryId = categoryId;
    }

    public static QuestionListCategoryId of(Integer questionListId, Integer categoryId) {
        return new QuestionListCategoryId(questionListId, categoryId);
    }

}
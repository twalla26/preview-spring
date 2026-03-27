package org.study.previewspring.questionlist.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "question_list_category")
public class QuestionListCategory {
    @EmbeddedId
    private QuestionListCategoryId id;

    @MapsId("questionListId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "question_list_id", nullable = false)
    private QuestionList questionList;

    @MapsId("categoryId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Builder(access = AccessLevel.PRIVATE)
    private QuestionListCategory(QuestionList questionList, Category category) {
        this.questionList = questionList;
        this.category = category;
        this.id = QuestionListCategoryId.of(questionList.getId(), category.getId());
    }

    public static QuestionListCategory create(QuestionList questionList, Category category) {
        return QuestionListCategory.builder()
                .questionList(questionList)
                .category(category)
                .build();
    }

}
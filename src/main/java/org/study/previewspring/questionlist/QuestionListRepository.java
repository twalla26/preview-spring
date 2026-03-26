package org.study.previewspring.questionlist;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.study.previewspring.questionlist.entity.QuestionList;

import java.util.List;

public interface QuestionListRepository extends JpaRepository<QuestionList, Integer> {

    Page<QuestionList> findAllByIsPublicTrue(Pageable pageable);

    @Query("SELECT DISTINCT ql FROM QuestionList ql " +
            "JOIN ql.questionListCategories qlc " +
            "WHERE ql.isPublic = true AND qlc.category.id = :categoryId")
    Page<QuestionList> findAllByIsPublicTrueAndCategoryId(
            @Param("categoryId") Integer categoryId,
            Pageable pageable);

    Page<QuestionList> findAllByUserId(Integer userId, Pageable pageable);

}

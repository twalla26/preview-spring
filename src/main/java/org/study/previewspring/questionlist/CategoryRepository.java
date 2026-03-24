package org.study.previewspring.questionlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.study.previewspring.questionlist.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByName(String name);

    @Query("SELECT c FROM Category c " +
            "JOIN c.questionListCategories qlc " +
            "WHERE qlc.questionList.id = :questionListId")
    List<Category> findAllByQuestionListId(@Param("questionListId") Integer questionListId);

    @Query("SELECT c.name FROM Category c " +
            "JOIN c.questionListCategories qlc " +
            "WHERE qlc.questionList.id = :questionListId")
    List<String> findCategoryNamesByQuestionListId(@Param("questionListId") Integer questionListId);

}

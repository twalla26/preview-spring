package org.study.previewspring.questionlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.study.previewspring.questionlist.entity.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findAllByQuestionListId(Integer questionListId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Question q SET q.index = q.index - 1 " +
            "WHERE q.questionList.id = :questionListId AND q.index > :deletedIndex")
    void updateIndicesAfterDelete(@Param("questionListId") Integer questionListId,
                                  @Param("deletedIndex") Integer deletedIndex);


    @Query("SELECT COUNT(*) FROM Question q " +
            "WHERE q.questionList.id = :questionListId")
    Integer countByQuestionListId(@Param("questionListId") Integer questionListId);

}

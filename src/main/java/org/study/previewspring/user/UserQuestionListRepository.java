package org.study.previewspring.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.previewspring.user.entity.UserQuestionList;

import java.util.List;

public interface UserQuestionListRepository extends JpaRepository<UserQuestionList, Integer> {

    List<UserQuestionList> findAllByUserId(Integer userId);

    void deleteByUserIdAndQuestionListId(Integer userId, Integer questinListId);

    boolean existsByUserIdAndQuestionListId(Integer userId, Integer questionListId);

}

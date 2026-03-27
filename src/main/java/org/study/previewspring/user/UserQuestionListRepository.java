package org.study.previewspring.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.study.previewspring.user.entity.User;
import org.study.previewspring.user.entity.UserQuestionList;

import java.util.List;
import java.util.Optional;

public interface UserQuestionListRepository extends JpaRepository<UserQuestionList, Integer> {

    Page<UserQuestionList> findAllByUserId(Integer userId, Pageable pageable);

    Optional<UserQuestionList> findByUserIdAndQuestionListId(Integer userId, Integer questinListId);

    boolean existsByUserIdAndQuestionListId(Integer userId, Integer questionListId);

    Integer countByQuestionListId(Integer questionListId);

}

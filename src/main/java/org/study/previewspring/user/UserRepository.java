package org.study.previewspring.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.previewspring.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

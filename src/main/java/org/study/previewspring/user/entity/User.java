package org.study.previewspring.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.study.previewspring.common.enums.LoginType;
import org.study.previewspring.questionlist.entity.QuestionList;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "login_id", unique = true, length = 20)
    private String loginId;

    @Column(name = "password_hash", length = 256)
    private String passwordHash;

    @Column(name = "username", nullable = false, unique = true, length = 20)
    private String username;

    @Column(name = "github_id", unique = true)
    private Integer githubId;

    @Column(name = "refresh_token", length = 200)
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "login_type", nullable = false, columnDefinition = "ENUM('local', 'github') DEFAULT 'local'")
    private LoginType loginType;

    @Column(name = "avatar_url", length = 320)
    private String avatarUrl;

    @OneToMany(mappedBy = "user")
    private Set<QuestionList> questionLists = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserQuestionList> scrappedQuestionLists = new LinkedHashSet<>();

}
package org.study.previewspring.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.study.previewspring.global.enums.LoginType;
import org.study.previewspring.questionlist.entity.QuestionList;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private List<QuestionList> questionLists = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserQuestionList> userQuestionLists = new ArrayList<>();

    @Builder(access = AccessLevel.PRIVATE)
    private User(String loginId,
                String passwordHash,
                String username,
                Integer githubId,
                String refreshToken,
                LoginType loginType,
                String avatarUrl) {
        this.loginId = loginId;
        this.passwordHash = passwordHash;
        this.username = username;
        this.githubId = githubId;
        this.refreshToken = refreshToken;
        this.loginType = loginType;
        this.avatarUrl = avatarUrl;
    }

    public static User createLocalUser(String loginId, String passwordHash, String username) {
        return User.builder()
                .loginId(loginId)
                .passwordHash(passwordHash)
                .username(username)
                .loginType(LoginType.local)
                .build();
    }

    public static User createGithubUser(Integer githubId, String passwordHash, String username) {
        return User.builder()
                .githubId(githubId)
                .passwordHash(passwordHash)
                .username(username)
                .loginType(LoginType.github)
                .build();
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}
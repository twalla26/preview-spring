package org.study.previewspring.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.study.previewspring.global.error.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 user를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;

}

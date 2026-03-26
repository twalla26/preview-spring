package org.study.previewspring.questionlist;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.study.previewspring.global.error.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum QuestionErrorCode implements ErrorCode {

    QUESTION_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 question을 찾을 수 없습니다."),
    INVALID_QUESTION_MATCH(HttpStatus.BAD_REQUEST, "해당 question이 지정된 question list에 속하지 않습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;

}

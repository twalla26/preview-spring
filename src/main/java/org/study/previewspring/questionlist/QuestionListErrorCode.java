package org.study.previewspring.questionlist;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.study.previewspring.global.error.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum QuestionListErrorCode implements ErrorCode {

    QUESTION_LIST_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 question list를 찾을 수 없습니다."),
    PRIVATE_LIST_ACCESS_DENIED(HttpStatus.FORBIDDEN, "비공개 question list입니다. 접근 권한이 없습니다."),
    UNAUTHORIZED_ACTION(HttpStatus.FORBIDDEN, "해당 question list에 대한 권한이 없습니다."),
    CANNOT_SCRAP_OWN_LIST(HttpStatus.BAD_REQUEST, "자신의 question list는 스크랩할 수 없습니다."),
    ALREADY_SCRAPPED(HttpStatus.BAD_REQUEST, "이미 스크랩한 question list입니다.");

    private final HttpStatus httpStatus;
    private final String message;

}

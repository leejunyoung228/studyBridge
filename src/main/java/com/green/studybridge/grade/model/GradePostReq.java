package com.green.studybridge.grade.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GradePostReq {
    @Schema(title = "사용자 PK", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long userId;
    @Schema(title = "수업 PK", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long classId;
    @Schema(title = "과목 점수 PK", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long subjectId;
    @Schema(title = "과목 점수", example = "90")
    private int score;
    @Schema(title = "패스 여부")
    private Integer pass;
    @Schema(title = "시험 날짜", example = "YYYY-MM-DD")
    private String examDate;
}
package com.green.studybridge.acaClass.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AcaClassPostReq {
    @JsonIgnore
    private long classId;

    @Schema(title = "학원 PK", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long acaId;
    @Schema(title = "수업 이름", example = "국어")
    private String className;
    @Schema(title = "수업 설명", example = "한국어와 문학에 대한 기본적인 이해를 배우는 과목입니다.")
    private String classComment;
    @Schema(title = "수업 시작 날짜", example = "2025-01-16")
    private String startDate;
    @Schema(title = "수업 종료 날짜", example = "2025-01-30")
    private String endDate;
    @Schema(title = "수업 시작 시간", example = "09:00")
    private String startTime;
    @Schema(title = "수업 종료 시간", example = "18:00")
    private String endTime;
    @Schema(title = "수강료", example = "100,000")
    private int price;

    @Schema(title = "수업일", example = "월")
    private String date;
    @Schema(title = "연령", example = "청소년")
    private String years;
    @Schema(title = "수준", example = "초급")
    private String level;
}

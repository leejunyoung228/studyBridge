package com.green.studybridge.acaClass.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AcaClassUserGetRes {
    private List<AcaClassUserDto> classUserList;
}
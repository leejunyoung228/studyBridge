package com.green.studybridge.acaClass.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AcaClassToUserGetRes {
    private List<AcaClassToUserDto> userClassList;
}

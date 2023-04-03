package com.test.onlinestream.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoSearchDTO {

    private String videoName;
    private String title;
    private Integer duration;
}
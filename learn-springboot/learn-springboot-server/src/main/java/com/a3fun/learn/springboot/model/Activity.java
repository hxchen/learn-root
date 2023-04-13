package com.a3fun.learn.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Activity {
    private Long id;
    private String name;
    private long startTime;
    private long endTime;

}

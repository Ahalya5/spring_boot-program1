package com.employe.job.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {

    private int id;
    private String name;
    private String company;
    private String department;
    private String role;
}

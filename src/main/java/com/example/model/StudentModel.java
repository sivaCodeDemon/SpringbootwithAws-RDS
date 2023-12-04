package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {

    private String stu_Name;

    private Float stu_Marks;

    private Boolean stu_Status;

}

package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PersonResponse {
    private String fullName;
    private Date dateOfBirth;
    private String contactType;
    private String contactValue;
}
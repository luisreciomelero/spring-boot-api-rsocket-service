package com.example.api.models;


import java.util.Objects;

import lombok.Builder;
import lombok.Data;

/*
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
*/
//@Entity
@Data
@Builder
public class Employee {

    //private @Id @GeneratedValue Long id;
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String role;


}
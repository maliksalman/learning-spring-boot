package com.example.learningspringboot.validation;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Foo {

    @Min(1899)
    @Max(2099)
    private int year;

    @Email
    private String email;

    @Pattern(regexp="^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$")
    private String ssn;

    @NotBlank
    private String name;
}
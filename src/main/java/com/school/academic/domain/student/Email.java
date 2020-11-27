package com.school.academic.domain.student;

import lombok.Getter;

@Getter
public class Email {

    //VALUE OBJECT

    private String email;

    public Email(String email) {
        if(email == null || !email.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("E-mail invalido");
        }
        this.email = email;
    }

}

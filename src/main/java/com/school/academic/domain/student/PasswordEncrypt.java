package com.school.academic.domain.student;

public interface PasswordEncrypt {

    String encrypt(String password);
    boolean validatePassword(String passwordEncrypt, String password);

}

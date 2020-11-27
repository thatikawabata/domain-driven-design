package com.school.academic.domain.student;

import com.school.shared.domain.CPF;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
//AGGREGATE ROOT
public class Student {

    private CPF cpf;
    private String name;
    private Email email;

    private List<Phone> phones = new ArrayList<>();

    private String password;

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public void addPhone(String ddd, String number){
        //INVARIANTS BUSINESS
        if(phones.size() == 2){
            throw new IllegalArgumentException("Número maximo de telefones já atingido!");
        }
        this.phones.add(new Phone(ddd, number));
    }

}

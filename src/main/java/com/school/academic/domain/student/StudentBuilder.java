package com.school.academic.domain.student;

import com.school.shared.domain.CPF;

public class StudentBuilder {

    private Student student;

    public StudentBuilder withNameCPFEmail(String name, String cpf, String email){
        this.student = new Student(new CPF(cpf), name, new Email(email));
        return this;
    }

    public StudentBuilder withPhone(String ddd, String number){
        this.student.addPhone(ddd, number);
        return this;
    }

    public Student create(){
        return this.student;
    }

}

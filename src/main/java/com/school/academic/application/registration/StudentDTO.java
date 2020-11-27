package com.school.academic.application.registration;

import com.school.academic.domain.student.Email;
import com.school.shared.domain.CPF;
import com.school.academic.domain.student.Student;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentDTO {

    private String nameStudent;
    private String cpfStudent;
    private String emailStudent;

    public Student create(){
        return new Student(
                new CPF(cpfStudent), nameStudent, new Email(emailStudent));
    }

}

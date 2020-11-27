package com.school.academic.domain.student;

import com.school.shared.domain.CPF;

import java.util.List;

public interface StudentRepository {

    void registration(Student student);
    Student findByCPF(CPF cpf);
    List<Student> findByAllRegistrationStudents();

}

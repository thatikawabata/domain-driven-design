package com.school.academic.infra.student;

import com.school.shared.domain.CPF;
import com.school.academic.domain.student.Student;
import com.school.academic.domain.student.StudentNotFound;
import com.school.academic.domain.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryInMemory implements StudentRepository {

    private List<Student> registrations = new ArrayList<>();

    @Override
    public void registration(Student student) {
        this.registrations.add(student);
    }

    @Override
    public Student findByCPF(CPF cpf) {
        return this.registrations.stream()
                .filter(s -> s.getCpf().getNumber().equals(cpf.getNumber()))
                .findFirst()
                .orElseThrow(() -> new StudentNotFound(cpf));
    }

    @Override
    public List<Student> findByAllRegistrationStudents() {
        return this.registrations;
    }
}

package com.school.academic.application.registration;

import com.school.academic.domain.student.LogRegistrationStudent;
import com.school.shared.event.PostedEvents;
import com.school.shared.domain.CPF;
import com.school.academic.infra.student.StudentRepositoryInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegisterStudentTest {

    @Test
    void savedStudent() {

        var respository = new StudentRepositoryInMemory();
        var posted = new PostedEvents();
        posted.add(new LogRegistrationStudent());
        var useCase = new RegisterStudent(respository, posted);

        var student = new StudentDTO("Fulano", "123.456.789-00", "fulano@email.com");
        useCase.execute(student);

        var studentFind = respository.findByCPF(new CPF("123.456.789-00"));

        assertEquals("Fulano", studentFind.getName());
        assertEquals("123.456.789-00", studentFind.getCpf().getNumber());
        assertEquals("fulano@email.com", studentFind.getEmail().getEmail());

    }



}

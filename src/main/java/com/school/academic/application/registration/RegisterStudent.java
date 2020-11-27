package com.school.academic.application.registration;

import com.school.academic.domain.student.RegistrationStudent;
import com.school.shared.event.PostedEvents;
import com.school.academic.domain.student.StudentRepository;

public class RegisterStudent {

    private final StudentRepository repository;
    private final PostedEvents postedEvents;

    public RegisterStudent(StudentRepository repository, PostedEvents postedEvents) {
        this.repository = repository;
        this.postedEvents = postedEvents;
    }


    //DESIGN PATTERN - COMMAND
    public void execute(StudentDTO studentDTO){
        var newStudent = studentDTO.create();
        repository.registration(newStudent);

        var event = new RegistrationStudent(newStudent.getCpf());
        postedEvents.publish(event);
    }

}

package com.school.academic.application.recommendation;

import com.school.academic.domain.student.Student;

public interface SendEmail {

    void sendTo(Student student);

}

package com.school;

import com.school.academic.application.registration.RegisterStudent;
import com.school.academic.application.registration.StudentDTO;
import com.school.academic.domain.student.LogRegistrationStudent;
import com.school.academic.infra.student.StudentRepositoryInMemory;
import com.school.gamification.application.GenerateMedal;
import com.school.gamification.infra.medal.MedalRepositoryInMemory;
import com.school.shared.event.PostedEvents;

public class RegistrationStudentMain {

    public static void main(String[] args) {
         var name = "Fulano da Silva";
         var cpf ="123.456.789-00";
         var email = "fulano@email.com";

         var posted = new PostedEvents();
         posted.add(new LogRegistrationStudent());
         posted.add(new GenerateMedal(new MedalRepositoryInMemory()));

         var registrationStudent = new RegisterStudent(new StudentRepositoryInMemory(), posted);
         registrationStudent.execute(new StudentDTO(name, cpf, email));

    }
}

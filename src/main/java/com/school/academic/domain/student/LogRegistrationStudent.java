package com.school.academic.domain.student;

import com.school.shared.event.Event;
import com.school.shared.event.Listener;

import java.time.format.DateTimeFormatter;

public class LogRegistrationStudent extends Listener {

    public void reactTo(Event event){
        var momentFormat = event.moment().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println(String.format("Aluno com CPF %s matriculado em %s",((RegistrationStudent) event).getCpf().getNumber(), momentFormat));
    }

    @Override
    protected boolean shouldProcess(Event event) {
        return event instanceof RegistrationStudent;
    }
}

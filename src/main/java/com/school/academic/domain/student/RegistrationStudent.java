package com.school.academic.domain.student;

import com.school.shared.event.Event;
import com.school.shared.domain.CPF;
import com.school.shared.event.EventTpe;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

public class RegistrationStudent implements Event {

    @Getter
    private final CPF cpf;
    private final LocalDateTime moment;

    public RegistrationStudent(CPF cpf) {
        this.cpf = cpf;
        this.moment = LocalDateTime.now();
    }

    @Override
    public LocalDateTime moment() {
        return this.moment;
    }

    @Override
    public EventTpe type() {
        return EventTpe.REGISTRATION_STUDENT;
    }

    @Override
    public Map<String, Object> information() {
        return Map.of("cpf", cpf);
    }

}

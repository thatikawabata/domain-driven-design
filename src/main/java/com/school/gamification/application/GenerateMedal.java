package com.school.gamification.application;

import com.school.gamification.domain.medal.Medal;
import com.school.gamification.domain.medal.MedalRepository;
import com.school.shared.domain.CPF;
import com.school.shared.event.Event;
import com.school.shared.event.EventTpe;
import com.school.shared.event.Listener;

public class GenerateMedal extends Listener {

    private final MedalRepository repository;

    public GenerateMedal(MedalRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void reactTo(Event event) {
        var cpf = (CPF) event.information().get("cpf");
        var medal = new Medal(cpf, "Novato");
        repository.add(medal);
    }

    @Override
    protected boolean shouldProcess(Event event) {
        return event.type() == EventTpe.REGISTRATION_STUDENT;
    }
}

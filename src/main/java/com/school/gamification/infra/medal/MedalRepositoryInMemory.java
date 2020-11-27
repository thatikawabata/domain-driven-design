package com.school.gamification.infra.medal;

import com.school.gamification.domain.medal.Medal;
import com.school.gamification.domain.medal.MedalRepository;
import com.school.shared.domain.CPF;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MedalRepositoryInMemory implements MedalRepository {

    private List<Medal> medals = new ArrayList<>();

    @Override
    public void add(Medal medal) {
        this.medals.add(medal);
    }

    @Override
    public List<Medal> findByAllStudentsMedals(CPF cpf) {
        return this.medals.stream()
                .filter(s -> s.getCpf().getNumber().equals(cpf.getNumber()))
                .collect(Collectors.toList());
    }
}

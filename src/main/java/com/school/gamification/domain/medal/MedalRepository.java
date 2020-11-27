package com.school.gamification.domain.medal;

import com.school.shared.domain.CPF;

import java.util.List;

public interface MedalRepository {

    void add(Medal medal);
    List<Medal> findByAllStudentsMedals(CPF cpf);

}

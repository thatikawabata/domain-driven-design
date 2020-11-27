package com.school.gamification.domain.medal;

import com.school.shared.domain.CPF;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Medal {

    private CPF cpf;
    private String name;
}

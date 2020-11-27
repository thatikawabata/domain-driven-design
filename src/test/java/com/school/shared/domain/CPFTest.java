package com.school.shared.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.school.shared.domain.CPF;
import org.junit.jupiter.api.Test;

class CPFTest {

    @Test
    void invalidCPF() {
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(null));

        assertThrows(IllegalArgumentException.class,
                () -> new CPF(""));

        assertThrows(IllegalArgumentException.class,
                () -> new CPF("12345678900"));
    }

    @Test
    void valiCPF() {
        var number = "123.456.789-00";
        var cpf = new CPF(number);
        assertEquals(number, cpf.getNumber());
    }

}

package com.school.academic.domain.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    void invalidEmail(){
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));

        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));

        assertThrows(IllegalArgumentException.class,
                () -> new Email("invalidEmail"));
    }

    @Test
    void validEmail(){
        var emailTest = "joao@gmail.com";
        var email = new Email(emailTest);
        assertEquals(emailTest, email.getEmail());
    }
}

package com.school.academic.domain.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PhoneTest {

    @Test
    void invalidDDD() {
        assertThrows(IllegalArgumentException.class,
                () -> new Phone(null, "123456789"));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("", "123456789"));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("1", "123456789"));
    }

    @Test
    void invalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("17", null));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("17", ""));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("17", "123"));
    }

    @Test
    void validPhoneNumber() {
        var ddd = "17";
        var number = "123456789";
        var phone = new Phone(ddd, number);
        assertEquals(ddd, phone.getDdd());
        assertEquals(number, phone.getNumber());
    }

}

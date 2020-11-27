package com.school.academic.domain.student;

import com.school.shared.domain.CPF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {

    private Student student;

    @BeforeEach
    void beforeEach(){
        this.student = new Student(new CPF("123.456.789-00"), "Fulano da Silva", new Email("fulano@email.com"));
    }

    @Test
    void addOnePhone() {
      this.student.addPhone("17", "999999999");
      assertEquals(1, this.student.getPhones().size());
    }

    @Test
    void addTwoPhones() {
        this.student.addPhone("17", "999999999");
        this.student.addPhone("17", "888888888");
        assertEquals(2, this.student.getPhones().size());
    }

    @Test
    void invalidAddThreePhones() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.student.addPhone("17", "999999999");
            this.student.addPhone("17", "888888888");
            this.student.addPhone("17", "777777777");
        });

    }

}

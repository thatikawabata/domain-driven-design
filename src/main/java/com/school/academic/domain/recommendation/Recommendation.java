package com.school.academic.domain.recommendation;

import com.school.academic.domain.student.Student;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Recommendation {

    private Student indicated;
    private Student indicative;
    private LocalDateTime recommendationDate;

    public Recommendation(Student indicated, Student indicative) {
        this.indicated = indicated;
        this.indicative = indicative;
        this.recommendationDate = LocalDateTime.now();
    }

}

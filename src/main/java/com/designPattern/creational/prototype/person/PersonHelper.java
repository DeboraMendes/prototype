package com.designPattern.creational.prototype.person;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Responsável por criar a pessoa base para prototipagem.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonHelper {

    public static Person createBasePersonForPrototyping() {
        return Person.builder()
                .name("Debora Mendes")
                .birthDate(LocalDate.of(1998, 3, 8))
                .phone("5511999999999")
                .email("debora.mendes@email.com")
                .document("99999999999")
                .build();
    }

}

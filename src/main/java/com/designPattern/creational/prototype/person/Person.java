package com.designPattern.creational.prototype.person;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.time.LocalDate;

/**
 * Representa a pessoa.
 */
@Setter
@Getter
@Builder
public class Person implements Cloneable {

    private String name;
    private LocalDate birthDate;
    private String phone;
    private String email;
    private String document;

    @SneakyThrows
    @Override
    public Person clone() {
        return (Person) super.clone();
    }

}

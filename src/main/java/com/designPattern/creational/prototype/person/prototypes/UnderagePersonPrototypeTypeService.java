package com.designPattern.creational.prototype.person.prototypes;

import com.designPattern.creational.prototype.person.Person;
import com.designPattern.creational.prototype.person.PersonPrototypeType;
import com.designPattern.creational.prototype.person.PersonPrototypeTypeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Responsável por criar o protótipo de pessoa do tipo menor de idade.
 */
@Service
public class UnderagePersonPrototypeTypeService implements PersonPrototypeTypeService {

    @Override
    public Person create(Person basePerson) {
        Person person = basePerson.clone();
        person.setBirthDate(LocalDate.now());
        return person;
    }

    @Override
    public PersonPrototypeType type() {
        return PersonPrototypeType.UNDERAGE;
    }

}

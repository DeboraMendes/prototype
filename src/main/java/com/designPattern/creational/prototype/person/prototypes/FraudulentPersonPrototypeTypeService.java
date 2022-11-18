package com.designPattern.creational.prototype.person.prototypes;

import com.designPattern.creational.prototype.person.Person;
import com.designPattern.creational.prototype.person.PersonPrototypeType;
import com.designPattern.creational.prototype.person.PersonPrototypeTypeService;
import org.springframework.stereotype.Service;

/**
 * Responsável por criar o protótipo de pessoa do tipo fraudenta.
 */
@Service
public class FraudulentPersonPrototypeTypeService implements PersonPrototypeTypeService {

    @Override
    public Person create(Person basePerson) {
        Person person = basePerson.clone();
        person.setEmail("fraudulent.person@email.com");
        return person;
    }

    @Override
    public PersonPrototypeType type() {
        return PersonPrototypeType.FRAUDULENT;
    }

}

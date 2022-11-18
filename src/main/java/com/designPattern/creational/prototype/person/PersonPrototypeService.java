package com.designPattern.creational.prototype.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Responsável por prover todos os protótipos de pessoas.
 */
@Service
@RequiredArgsConstructor
public class PersonPrototypeService {
    private final List<PersonPrototypeTypeService> prototypes;

    public Map<PersonPrototypeType, Person> getPrototypes() {
        final Map<PersonPrototypeType, Person> persons = new HashMap<>();
        Person basePerson = PersonHelper.createBasePersonForPrototyping();
        prototypes.forEach(prototype -> persons.put(prototype.type(), prototype.create(basePerson)));
        return persons;
    }

}

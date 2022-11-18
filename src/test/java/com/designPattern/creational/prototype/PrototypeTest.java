package com.designPattern.creational.prototype;

import com.designPattern.creational.prototype.person.Person;
import com.designPattern.creational.prototype.person.PersonPrototypeService;
import com.designPattern.creational.prototype.person.PersonPrototypeType;
import com.designPattern.creational.prototype.person.PersonPrototypeTypeService;
import com.designPattern.creational.prototype.person.prototypes.FraudulentPersonPrototypeTypeService;
import com.designPattern.creational.prototype.person.prototypes.IncompletePersonPrototypeTypeService;
import com.designPattern.creational.prototype.person.prototypes.UnderagePersonPrototypeTypeService;
import com.designPattern.creational.prototype.person.prototypes.ValidPersonPrototypeTypeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

/**
 * O Prototype, também conhecido como Protótipo ou Clone,
 * é um padrão de projeto criacional que permite
 * copiar objetos existentes sem fazer o código ficar dependente de outras classes.
 */
@RunWith(MockitoJUnitRunner.class)
public class PrototypeTest {

    @InjectMocks
    private PersonPrototypeService personPrototypeService;

    @Spy
    private ArrayList<PersonPrototypeTypeService> prototypes;

    private Map<PersonPrototypeType, Person> persons;

    @Before
    public void init() {
        prototypes.add(new FraudulentPersonPrototypeTypeService());
        prototypes.add(new IncompletePersonPrototypeTypeService());
        prototypes.add(new UnderagePersonPrototypeTypeService());
        prototypes.add(new ValidPersonPrototypeTypeService());
        persons = personPrototypeService.getPrototypes();
    }

    /**
     * Deve testar se o protótipo foi criado conforme o tipo solicitado.
     */
    @Test
    public void test() {
        Person validPerson = persons.get(PersonPrototypeType.VALID);
        Person underagePerson = persons.get(PersonPrototypeType.UNDERAGE);
        Person fraudulentPerson = persons.get(PersonPrototypeType.FRAUDULENT);
        Person incompletePerson = persons.get(PersonPrototypeType.INCOMPLETE);

        Assert.assertEquals("Debora Mendes", validPerson.getName());
        Assert.assertEquals(LocalDate.of(1998, 3, 8), validPerson.getBirthDate());
        Assert.assertEquals("5511999999999", validPerson.getPhone());
        Assert.assertEquals("debora.mendes@email.com", validPerson.getEmail());
        Assert.assertEquals("99999999999", validPerson.getDocument());

        Assert.assertEquals(LocalDate.now(), underagePerson.getBirthDate());

        Assert.assertEquals("fraudulent.person@email.com", fraudulentPerson.getEmail());

        Assert.assertNull(incompletePerson.getDocument());
    }


}
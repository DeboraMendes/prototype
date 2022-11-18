package com.designPattern.creational.prototype.person;

/**
 * Responsável por criar o protótipo de pessoa.
 */
public interface PersonPrototypeTypeService {

    /**
     * Responsável por criar o protótipo de pessoa utilizando outra pessoa como base.
     *
     * @param basePerson pessoa base para a criação do protótipo.
     * @return protótipo criado.
     */
    Person create(Person basePerson);

    /**
     * @return tipo do protótipo criado.
     */
    PersonPrototypeType type();

}

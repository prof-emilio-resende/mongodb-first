package br.com.fit.sqlproject.services.types;

import java.util.List;
import java.util.UUID;

import br.com.fit.sqlproject.models.Person;

public interface PersonServiceTemplate {
    public List<Person> all();
    public Person retrieve(UUID personId);
    public Person create(Person person);
    public Person update(Person person);
    public Person destroy(Person person);
}

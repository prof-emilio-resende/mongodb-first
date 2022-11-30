package br.com.fit.sqlproject.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fit.sqlproject.models.Person;

public interface PersonRepository extends MongoRepository<Person, UUID> {
}

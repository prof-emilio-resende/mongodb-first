package br.com.fit.sqlproject.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fit.sqlproject.models.Person;
import br.com.fit.sqlproject.services.types.PersonServiceTemplate;

@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired
    private PersonServiceTemplate svc;

    @GetMapping("/")
    public List<Person> all() {
        return svc.all();
    }

    @GetMapping("/{personId}")
    public Person get(@PathVariable UUID personId) {
        return svc.retrieve(personId);
    }

    @PostMapping("/")
    public Person create(@RequestBody Person person) {
        return svc.create(person);
    }

    @PutMapping("/{personId}")
    public Person update(@PathVariable UUID personId, @RequestBody Person person) {
        var p = svc.retrieve(personId);
        p.setName(person.getName());
        return svc.update(p);
    }

    @DeleteMapping("{personId}")
    public Person delete(@PathVariable UUID personId) {
        var p = svc.retrieve(personId);
        return svc.destroy(p);
    }
}

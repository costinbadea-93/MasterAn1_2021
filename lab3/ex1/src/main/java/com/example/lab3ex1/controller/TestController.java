package com.example.lab3ex1.controller;

import com.example.lab3ex1.model.Person;
import com.example.lab3ex1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private final PersonService personService;

    public TestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public List<Person> listPerson(){
        return personService.retrieveAllPerson();
    }
}

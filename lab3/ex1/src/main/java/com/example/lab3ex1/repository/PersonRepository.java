package com.example.lab3ex1.repository;

import com.example.lab3ex1.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {

    private static List<Person> personList = new ArrayList<>();

    public PersonRepository() {
        Person p1 = new Person("P2 First Name", "P2 Last Name", 23);
        Person p2 = new Person("P1 First Name", "P1 Last Name", 21);
        Person p3 = new Person("P3 First Name", "P3 Last Name", 25);

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
    }

    public List<Person> retrieveAllPerson() {
        return personList;
    }

    public String addPerson(Person person) {
        personList.add(person);
        return "A new person has been added with success!";
    }

    public String deletePerson(String firstName){
        personList = personList.stream()
                .filter(person -> !person.getFirstName().equals(firstName))
                .collect(Collectors.toList());

        return "Person with name " + firstName + "has been deleted!";
    }
}

package com.example.wallet.services;

import com.example.wallet.interfaces.IPersonService;
import com.example.wallet.models.Item;
import com.example.wallet.models.Person;
import com.example.wallet.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class PersonService implements IPersonService {

    @Autowired
    PersonRepository personRepository;

    public ArrayList<Person> getAllItem(){
        return (ArrayList<Person>) personRepository.findAll();
    }

    public Person save(Person person){
        return personRepository.save(person);
    }


    @Override
    public ArrayList<Person> getPerson() {
        ArrayList<Person> personArrayList= (ArrayList<Person>) personRepository.findAll();
        return null;
    }

    @Override
    public void savePerson(Person person) {
    personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
    personRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        return person;
    }
}

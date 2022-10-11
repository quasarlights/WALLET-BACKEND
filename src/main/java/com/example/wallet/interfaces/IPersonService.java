package com.example.wallet.interfaces;


import com.example.wallet.models.Person;
import java.util.ArrayList;

public interface IPersonService {

    public ArrayList<Person> getPerson();
    public void savePerson(Person person);
    public void deletePerson(Long id);
    public Person findPerson(Long id);
}

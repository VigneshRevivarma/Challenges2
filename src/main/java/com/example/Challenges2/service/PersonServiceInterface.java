package com.example.Challenges2.service;

import com.example.Challenges2.dao.PersonDao;
import com.example.Challenges2.model.Person;

import java.util.List;

public interface PersonServiceInterface {

    Person getPersonById(int id);

    List<PersonDao> getAllPerson();

    void updatePerson(int id, String address,String postcode ,String job,String email, int age, String phoneNumber);

    void deleteAcc(int id);

    Person createPerson(Person person);
}
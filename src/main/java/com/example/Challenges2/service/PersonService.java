package com.example.Challenges2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Challenges2.dao.PersonDao;
import com.example.Challenges2.model.Person;
import com.example.Challenges2.repository.PersonRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonServiceInterface{
    @Autowired
    private PersonRepo pr;

    public Person getPersonById(int id){
        Optional<Person> person = pr.findById(id);
        return person.orElse(null);
    }

    public List<PersonDao> getAllPerson(){
        Iterable<Person> perLis = pr.findAll();
        List<PersonDao> pdl = new ArrayList<>();
        if(perLis != null){
            perLis.forEach( person -> {
                        PersonDao pd = new PersonDao();
                        pd.setEmail(person.getEmail());
                        pd.setJob(person.getJob());
                        pd.setName(person.getName());
                        pd.setPostcode(person.getPostcode());
                        pd.setPhoneNo(person.getPhoneNumber());
                        pd.setId(person.getId());
                        pd.setAddress(person.getAddress());
                        pd.setAge(person.getAge());
                        pdl.add(pd);
                    }

            );
        }
        return pdl;
    }

    public void updatePerson(int id, String address,String postcode ,String job,String email, int age, String phoneNumber){
        pr.updateById(address,postcode,age,job,email,phoneNumber,id);
    }

    public void deleteAcc(int id){
        pr.deleteById(id);
    }

    public Person createPerson(Person person){
        return pr.save(person);
    }

}

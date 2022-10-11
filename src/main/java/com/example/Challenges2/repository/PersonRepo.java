package com.example.Challenges2.repository;
import com.example.Challenges2.model.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepo extends CrudRepository<Person,Integer> {

    @Override
    Optional<Person> findById(Integer id);


    @Override
    List<Person> findAll();


    @Override
    void deleteById(Integer id);

    @Transactional
    @Modifying
    @Query("update Person p set p.address = ?1, p.postcode = ?2, p.age = ?3, p.job = ?4, p.email = ?5, p.phoneNumber = ?6 " +
            "where p.id = ?7")
    void updateById(String address, String postcode, int age, String job, String email, String phoneNumber, int id);


}

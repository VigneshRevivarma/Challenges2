package com.example.Challenges2.repository;

import com.example.Challenges2.model.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface AccountRepo extends CrudRepository<Account,Integer> {

    @Override
    Optional<Account> findById(Integer integer);

    @Override
    Iterable<Account> findAll();

    @Transactional
    @Modifying
    @Query("update Account a set a.balance = ?1, a.date = ?2 where a.id = ?3")
    int updateAccount(String balance, Date date, int id);


}
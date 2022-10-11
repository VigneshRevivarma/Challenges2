package com.example.Challenges2.service;

import com.example.Challenges2.dao.AccountDao;
import com.example.Challenges2.model.Account;
import com.example.Challenges2.exception.ExceptionNotFound;
import com.example.Challenges2.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountService {

    @Autowired
    private AccountRepo ar;

    public List<AccountDao> getAllAccounts(){
        List<Account> accList = (List<Account>) ar.findAll();
        List<AccountDao> accountDaoList = new ArrayList<>();
        if(!accList.isEmpty()){
            accList.forEach(acc->{
                AccountDao accdao = new AccountDao();
                accdao.setAccName(acc.getAccName());
                accdao.setAccType(acc.getAccType());
                accdao.setAccNumber(acc.getAccNumber());
                accdao.setBalance(acc.getBalance());
                accdao.setDate(acc.getDate());
                accountDaoList.add(accdao);
            });
        }
        return accountDaoList;
    }

    public Account getAccByid(int id)throws RuntimeException{
        Optional<Account> acc = ar.findById(id);
        return acc.orElseThrow(()-> new ExceptionNotFound("User not Found"));
    }

    public void updateAcc(int balance, int id){
        LocalDate dateNow = LocalDate.now();
        Date date = Date.valueOf(String.valueOf(dateNow));
        ar.updateAccount(String.valueOf(balance), date, id);
    }

    public void deleteAcc(int id){
        ar.deleteById(id);
    }

    public Account createAccount(Account acc){
        LocalDate d =LocalDate.now();
        Date date = Date.valueOf(String.valueOf(d));
        System.out.println("Account created on: " + date);
        acc.setDate(date);
        return ar.save(acc);
    }
}

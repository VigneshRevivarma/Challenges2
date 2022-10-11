package com.example.Challenges2.service;

import com.example.Challenges2.dao.AccountDao;
import com.example.Challenges2.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountServiceInterface {
    List<AccountDao> getAllAccounts() throws Exception;
    Account getAccByid(int id);
    void updateAcc(int balance, int id);
    void deleteAcc(int id);
    Account createAccount(Account accs);
}

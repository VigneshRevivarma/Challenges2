package com.example.Challenges2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Challenges2.dao.AccountDao;
import com.example.Challenges2.model.Account;
import com.example.Challenges2.service.AccountService;
import com.example.Challenges2.service.AccountServiceInterface;
import com.example.Challenges2.repository.AccountRepo;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountServiceInterface accs;
    @Autowired
    private AccountRepo ar;


    @GetMapping("/account")
    public ResponseEntity<Object> getAllAccounts() {
        List<AccountDao> appList;
        try {
            appList = accs.getAllAccounts();
        } catch (Exception e) {
            appList = null;
            System.out.println(e);
        }
        return ResponseEntity.ok().header("OK!").body(appList);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createAccount(@RequestBody Account acc) {
//        System.out.println(acc.getAccName());
        Account appDetail = accs.createAccount(acc);
        return ResponseEntity.ok().header("Created!").body(appDetail);
    }

    @GetMapping("/account/{id}")
    @ResponseBody
    public ResponseEntity<Object> getAccountById(@PathVariable("id") int id) {
        Account appointment = accs.getAccByid(id);
        return ResponseEntity.ok().body(appointment);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateAccount(@PathVariable(name = "id") int id, @RequestBody Account acc) {

        accs.updateAcc(acc.getBalance(), acc.getId());
        return ResponseEntity.ok("Updated!");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteAppointment(@PathVariable int id) {
        accs.deleteAcc(id);
        return ResponseEntity.ok("Deleted");
    }
}

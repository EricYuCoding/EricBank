package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Accounts;
import com.eazybytes.springsecuritybasic.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountsRepository accountsRepository;

    @GetMapping
    public Accounts getAccountDetails(@RequestParam int id){
        Accounts accounts = accountsRepository.findByCustomerId(id);
        if(accounts != null){
            return accounts;
        }else {
            return null;
        }
    }
}

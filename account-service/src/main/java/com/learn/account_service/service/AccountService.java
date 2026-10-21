package com.learn.account_service.service;

import com.learn.account_service.model.Account;
import com.learn.account_service.repository.AccountRepository;
import com.learn.account_service.utils.AccountCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class AccountService {
    private final AccountRepository repository;
    private final KafkaTemplate<String, AccountCreatedEvent> kafkaTemplate;

    public AccountService(AccountRepository repository,KafkaTemplate<String,AccountCreatedEvent> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
        this.repository=repository;
    }

    public Account createAccount(String holderName, BigDecimal initialBalance){
        Account account=new Account();
        account.setHolderName(holderName);
        account.setBalance(initialBalance);
        account.setStatus("ACTIVE");
        Account saved=repository.save(account);
        kafkaTemplate.send("account-events",String.valueOf(saved.getId()),new AccountCreatedEvent(saved.getId(),saved.getHolderName(),saved.getBalance(), Instant.now()));
        return saved;
    }
}

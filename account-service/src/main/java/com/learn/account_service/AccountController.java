package com.learn.account_service;

import com.learn.account_service.model.Account;
import com.learn.account_service.repository.AccountRepository;
import com.learn.account_service.service.AccountService;
import com.learn.account_service.utils.KafkaTopicConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService service;
    private final AccountRepository repository;

    public AccountController(AccountRepository repository,AccountService service){
        this.repository=repository;
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestParam String holderName, @RequestParam BigDecimal balance){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAccount(holderName,balance));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable Long id){
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

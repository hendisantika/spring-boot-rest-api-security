package com.hendisantika.springbootrestapisecurity.service;

import com.hendisantika.springbootrestapisecurity.entity.Account;
import com.hendisantika.springbootrestapisecurity.entity.AccountRole;
import com.hendisantika.springbootrestapisecurity.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-api-security
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/08/21
 * Time: 10.01
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initialize() {
        if (accountRepository.findOneByUsername("kamino") == null) {
            save(new Account("kamino", "kamino", AccountRole.KAMINOAIN.name()));
        }
        if (accountRepository.findOneByUsername("palpatine") == null) {
            save(new Account("palpatine", "palpatine", AccountRole.EMPEROR.name()));
        }
    }

    @Transactional
    private Account save(Account user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return accountRepository.save(user);
    }

}

package com.hendisantika.springbootrestapisecurity.controller;

import com.hendisantika.springbootrestapisecurity.repository.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-api-security
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/08/21
 * Time: 10.14
 */
@RestController
@RequestMapping("/kamino/clones")
public class HumanCloningController {

    @Autowired
    private CloneRepository repository;
}

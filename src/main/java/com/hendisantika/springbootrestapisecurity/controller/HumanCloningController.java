package com.hendisantika.springbootrestapisecurity.controller;

import com.hendisantika.springbootrestapisecurity.entity.Clone;
import com.hendisantika.springbootrestapisecurity.repository.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private CloneRepository cloneRepository;

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")
    public List<Clone> findAll() {
        return cloneRepository.findAll();
    }
}

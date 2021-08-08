package com.hendisantika.springbootrestapisecurity.repository;

import com.hendisantika.springbootrestapisecurity.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-api-security
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/08/21
 * Time: 09.59
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findOneByUsername(String username);
}

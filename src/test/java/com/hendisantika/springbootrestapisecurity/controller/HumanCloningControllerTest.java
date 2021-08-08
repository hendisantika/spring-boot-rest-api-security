package com.hendisantika.springbootrestapisecurity.controller;

import com.hendisantika.springbootrestapisecurity.SpringBootRestApiSecurityApplication;
import com.hendisantika.springbootrestapisecurity.repository.CloneRepository;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-api-security
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/08/21
 * Time: 05.34
 */
@SpringBootTest(classes = SpringBootRestApiSecurityApplication.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class HumanCloningControllerTest {
    private HumanCloningController controller;

    @MockBean
    private CloneRepository repository;

}

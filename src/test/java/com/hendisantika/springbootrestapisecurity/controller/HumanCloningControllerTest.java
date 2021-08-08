package com.hendisantika.springbootrestapisecurity.controller;

import com.hendisantika.springbootrestapisecurity.SpringBootRestApiSecurityApplication;
import com.hendisantika.springbootrestapisecurity.entity.Clone;
import com.hendisantika.springbootrestapisecurity.repository.CloneRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

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

    @Test
    public void shouldCreateBean_OK() throws Exception {
        // Given
        Clone input = getClone(null);
        Clone saved = getClone(1L);
        Mockito.when(repository.save(input)).thenReturn(saved);

        // When
        Clone output = controller.createClone(input);

        // Then
        Assert.assertNotNull(output);
        Mockito.verify(repository).save(input);
        Assert.assertEquals(saved, output);
    }

    @Test
    public void shouldFindOneBean_OK() throws Exception {
        // Given
        Long input = 1L;
        Clone found = getClone(input);
        Optional<Clone> inDb = Optional.ofNullable(found);
        Mockito.when(repository.findById(input)).thenReturn(inDb);

        // When
        Clone output = controller.findById(input);

        // Then
        Assert.assertNotNull(output);
        Mockito.verify(repository).findById(input);
        Assert.assertEquals(found, output);
    }

}

package com.hendisantika.springbootrestapisecurity.controller;

import com.hendisantika.springbootrestapisecurity.SpringBootRestApiSecurityApplication;
import com.hendisantika.springbootrestapisecurity.entity.Clone;
import com.hendisantika.springbootrestapisecurity.entity.CloneType;
import com.hendisantika.springbootrestapisecurity.exception.BeanNotFound;
import com.hendisantika.springbootrestapisecurity.repository.CloneRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@RunWith(SpringJUnit4ClassRunner.class)
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

    public static Clone getClone(Long id) {
        Clone clone = new Clone();

        clone.setId(id);
        clone.setPlatoon(501);
        clone.setType(CloneType.gunner);
        clone.setCodeName("CT-7567");

        return clone;
    }

    @Test
    public void shouldFindOneBean_KO_NotFound() throws Exception {

        Assertions.assertThrows(BeanNotFound.class, () -> {
            // Given
            Long input = 1L;
            Optional<Clone> inDb = Optional.ofNullable(null);
            Mockito.when(repository.findById(input)).thenReturn(inDb);

            // When
            controller.findById(input);

            // Then
        });

    }

}

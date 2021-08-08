package com.hendisantika.springbootrestapisecurity.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-api-security
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/08/21
 * Time: 09.51
 */
@Entity
@Data
public class Clone {

    private final String birthPlace = "Kamino";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @NotNull
    private String codeName;

    @NotNull
    @Enumerated
    private CloneType type;

    @Nullable
    private int platoon;

    private String affiliation = "Galactic Republic";
}

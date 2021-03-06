package com.hendisantika.springbootrestapisecurity.controller;

import com.hendisantika.springbootrestapisecurity.entity.Clone;
import com.hendisantika.springbootrestapisecurity.exception.BeanNotFound;
import com.hendisantika.springbootrestapisecurity.repository.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/pages")
    @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")
    public Page<Clone> findAllPages(@PageableDefault(page = 0, size = 20)
                                    @SortDefault.SortDefaults({
                                            @SortDefault(sort = "id", direction = Sort.Direction.ASC)
                                    }) Pageable pageable) {
        return cloneRepository.findAll(pageable);
    }

    @PostMapping()
    @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")
    public Clone createClone(@RequestBody Clone clone) {
        return cloneRepository.save(clone);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")
    public Clone findById(@PathVariable("id") Long id) throws BeanNotFound {
        return getOne(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")
    public void delete(@PathVariable("id") Long id) throws BeanNotFound {
        Clone clone = getOne(id);
        cloneRepository.delete(clone);
    }

    @PutMapping("/order66")
    @PreAuthorize("hasAuthority('ROLE_EMPEROR')")
    public List<Clone> executeOrder66() {
        List<Clone> clones = cloneRepository.findAll();
        clones.stream().forEach(clone -> clone.setAffiliation("Galactic Empire"));
        return cloneRepository.saveAll(clones);
    }

    protected Clone getOne(Long id) throws BeanNotFound {
        Optional<Clone> clone = cloneRepository.findById(id);
        if (!clone.isPresent()) {
            throw new BeanNotFound("Can't find clone with id : " + id);
        }
        return clone.get();
    }


}

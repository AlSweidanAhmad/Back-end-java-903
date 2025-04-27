package com.spring.boot.task.repo;

import com.spring.boot.task.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailRepo extends JpaRepository<Email, Long> {
    List<Email> findByType(String type);
    List<Email> findByTypeIn(List<String> types);
    Optional<Email> findByValue(String value);


}

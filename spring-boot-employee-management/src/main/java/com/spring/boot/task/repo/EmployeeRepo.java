package com.spring.boot.task.repo;

import com.spring.boot.task.model.Email;
import com.spring.boot.task.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findAllByNameInIgnoreCase(List<String> names);
}

package com.internship.introproject.repository;

import com.internship.introproject.entity.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodosRepository extends JpaRepository<Todos, Long> {
}

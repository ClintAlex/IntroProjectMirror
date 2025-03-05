package com.internship.introproject.repository;

import com.internship.introproject.entity.Albums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<Albums, Long> {
}

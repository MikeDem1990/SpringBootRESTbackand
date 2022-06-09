package com.javaRestful.springboot.repository;

import com.javaRestful.springboot.model.empl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmplRepository extends JpaRepository<empl,Long> {
}

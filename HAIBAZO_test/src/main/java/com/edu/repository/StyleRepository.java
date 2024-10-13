package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.model.Style;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long>{

}

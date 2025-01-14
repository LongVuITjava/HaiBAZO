package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.model.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long>{

}

package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.model.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long>{

}

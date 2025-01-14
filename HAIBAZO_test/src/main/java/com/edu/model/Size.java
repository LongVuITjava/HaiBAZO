package com.edu.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sizes")
public class Size implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sizeId;

    private String sizeName;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}

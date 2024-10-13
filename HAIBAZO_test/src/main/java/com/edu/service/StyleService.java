package com.edu.service;

import java.util.List;
import java.util.Optional;

import com.edu.model.Style;

public interface StyleService {

	void deleteStyle(Long styleId);

	Style saveStyle(Style style);

	Optional<Style> getStyleById(Long styleId);

	List<Style> getAllStyles();

}

package com.edu.service;

import java.util.List;
import java.util.Optional;

import com.edu.model.Color;

public interface ColorService {

	void deleteColor(Long colorId);

	Color saveColor(Color color);

	Optional<Color> getColorById(Long colorId);

	List<Color> getAllColors();

}

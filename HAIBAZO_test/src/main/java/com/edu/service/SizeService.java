package com.edu.service;

import java.util.List;
import java.util.Optional;

import com.edu.model.Size;

public interface SizeService {

	void deleteSize(Long sizeId);

	Size saveSize(Size size);

	Optional<Size> getSizeById(Long sizeId);

	List<Size> getAllSizes();

}

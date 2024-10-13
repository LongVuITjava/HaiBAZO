package com.edu.serviceImpl;

import com.edu.model.Color;
import com.edu.repository.ColorRepository;
import com.edu.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public Optional<Color> getColorById(Long colorId) {
        return colorRepository.findById(colorId);
    }

    @Override
    public Color saveColor(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public void deleteColor(Long colorId) {
        colorRepository.deleteById(colorId);
    }
}


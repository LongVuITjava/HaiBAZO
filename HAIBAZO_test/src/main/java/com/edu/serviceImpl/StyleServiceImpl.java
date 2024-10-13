package com.edu.serviceImpl;


import com.edu.model.Style;
import com.edu.repository.StyleRepository;
import com.edu.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StyleServiceImpl implements StyleService {

    @Autowired
    private StyleRepository styleRepository;

    @Override
    public List<Style> getAllStyles() {
        return styleRepository.findAll();
    }

    @Override
    public Optional<Style> getStyleById(Long styleId) {
        return styleRepository.findById(styleId);
    }

    @Override
    public Style saveStyle(Style style) {
        return styleRepository.save(style);
    }

    @Override
    public void deleteStyle(Long styleId) {
        styleRepository.deleteById(styleId);
    }
}

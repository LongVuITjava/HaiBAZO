package com.edu.serviceImpl;

import com.edu.model.Size;
import com.edu.repository.SizeRepository;
import com.edu.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    @Override
    public Optional<Size> getSizeById(Long sizeId) {
        return sizeRepository.findById(sizeId);
    }

    @Override
    public Size saveSize(Size size) {
        return sizeRepository.save(size);
    }

    @Override
    public void deleteSize(Long sizeId) {
        sizeRepository.deleteById(sizeId);
    }
}

package com.example.library.service;

import com.example.library.entity.Material;
import com.example.library.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public void createMaterial(Material material) {
        materialRepository.createMaterial(material);
    }

    public List<Material> getMaterials() {
        return materialRepository.getMaterials();
    }

    public Material findById(int id) {
        return materialRepository.findById(id);
    }

    public void updateMaterial(int id, Material material) {
        materialRepository.updateMaterial(id, material);
    }
}

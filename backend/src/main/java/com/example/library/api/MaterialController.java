package com.example.library.api;

import com.example.library.entity.Material;
import com.example.library.service.MaterialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MaterialController {
    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }


    @PostMapping(value = "/material")
    @ResponseBody
    public void createMaterial(@RequestBody Material material){

        materialService.createMaterial(material);
    }

    @GetMapping(value = "/materials")
    @ResponseBody
    public List<Material> getMaterials(){

        return materialService.getMaterials();
    }

    @GetMapping(value = "/material/{id}")
    @ResponseBody
    public Material findById(@PathVariable("id") int id){

        return materialService.findById(id);
    }

    @PutMapping(value = "/material/{id}")
    @ResponseBody
    public void updateMaterial(@PathVariable("id") int id, @RequestBody Material updatedMaterial){

        materialService.updateMaterial(id, updatedMaterial);
    }
}

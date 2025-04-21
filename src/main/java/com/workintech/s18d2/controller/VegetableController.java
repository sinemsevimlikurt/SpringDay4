package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import com.workintech.s18d2.validations.IdValidation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private final VegetableService service;

    public VegetableController(VegetableService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vegetable> getAll() {
        return service.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable Long id) {
        IdValidation.checkId(id);
        return service.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getDesc() {
        return service.getByPriceDesc();
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> search(@PathVariable String name) {
        return service.searchByName(name);
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable) {
        return service.save(vegetable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        IdValidation.checkId(id);
        Vegetable deleted = service.delete(id);
        Map<String, Object> resp = new HashMap<>();
        resp.put("message", "Vegetable deleted successfully");
        resp.put("vegetable", deleted);
        return ResponseEntity.ok(resp);
    }
}
package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.validations.IdValidation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/fruit")
public class FruitController {
    private final FruitService fruitService;
    public FruitController(com.workintech.s18d2.services.FruitService fruitService) { this.fruitService = fruitService; }

    @GetMapping
    public List<Fruit> getAll() { return fruitService.getByPriceAsc(); }

    @GetMapping("/{id}")
    public Fruit getById(@PathVariable Long id) {
        IdValidation.checkId(id);
        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getDesc() { return fruitService.getByPriceDesc(); }

    @GetMapping("/name/{name}")
    public List<Fruit> search(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> delete(@PathVariable Long id) {
        IdValidation.checkId(id);
        Fruit deleted = fruitService.delete(id);
        Map<String,Object> resp = new HashMap<>();
        resp.put("message", "Fruit deleted successfully");
        resp.put("fruit", deleted);
        return ResponseEntity.ok(resp);
    }
}
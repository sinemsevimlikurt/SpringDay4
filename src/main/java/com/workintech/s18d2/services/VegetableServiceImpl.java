package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VegetableServiceImpl implements VegetableService {
    private final VegetableRepository repository;

    public VegetableServiceImpl(VegetableRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vegetable getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PlantException("Vegetable not found"));
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return repository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return repository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return repository.searchByName(name);
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return repository.save(vegetable);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable v = getById(id);
        repository.delete(v);
        return v;
    }
}
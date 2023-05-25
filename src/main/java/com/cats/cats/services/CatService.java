package com.cats.cats.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cats.cats.models.CatModel;
import com.cats.cats.repositories.CatRepository;

@Service
public class CatService {
    @Autowired
    CatRepository catRepository;

    public ArrayList<CatModel> getCats() {
        return (ArrayList<CatModel>) catRepository.findAll();
    }

    public CatModel saveCat(CatModel cat) {
        return catRepository.save(cat);
    }

    public CatModel addCat(CatModel cat) {
        return catRepository.save(cat);
    }

    public CatModel getCatById(Long id) {
        return catRepository.findById(id)
            .orElseThrow(NoSuchElementException::new);
    }

    public CatModel updateCat(Long id, CatModel catModel) {
        CatModel existingCat = catRepository.findById(id)
                .orElseThrow();

        existingCat.setImg(catModel.getImg());
        existingCat.setName(catModel.getName());
        existingCat.setDescription(catModel.getDescription());
        existingCat.setWeight(catModel.getWeight());
        existingCat.setTemperament(catModel.getTemperament());
        existingCat.setOrigin(catModel.getOrigin());
        existingCat.setLife_span(catModel.getLife_span());

        CatModel updatedCat = catRepository.save(existingCat);

        return updatedCat;
    }

    public void deleteCatById(Long id) {
        catRepository.deleteById(id);
    }

    public void deleteAllCats() {
        catRepository.deleteAll();
    }
}

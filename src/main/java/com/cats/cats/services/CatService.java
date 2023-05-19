package com.cats.cats.services;

import java.util.ArrayList;

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
}

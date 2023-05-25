package com.cats.cats.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cats.cats.models.CatModel;

public interface CatRepository extends CrudRepository<CatModel, Long> {

}

package com.cats.cats.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cats.cats.models.CatModel;

@Repository
public interface CatRepository extends CrudRepository<CatModel, Long> {

}

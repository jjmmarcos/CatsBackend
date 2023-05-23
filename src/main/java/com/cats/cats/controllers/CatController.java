package com.cats.cats.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cats.cats.models.CatModel;
import com.cats.cats.services.CatService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cats")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public List<CatModel> getCats() {
        return catService.getCats();
    }

    @GetMapping("/{id}")
    public CatModel getCatById(@PathVariable("id") Long id) {
        return catService.getCatById(id);
    }

    @PostMapping
    public ResponseEntity<CatModel> addCat(@RequestBody CatModel cat) {
        CatModel newCat = catService.addCat(cat);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCat);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<CatModel> updateCat(@PathVariable Long id, @RequestBody CatModel catModel) {
        CatModel updatedCat = catService.updateCat(id, catModel);
        return ResponseEntity.ok(updatedCat);
    }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> eliminarGato(@PathVariable("id") Long id) {
    //     boolean eliminado = gatoService.eliminarGato(id);
    //     if (eliminado) {
    //         return ResponseEntity.noContent().build();
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }
}
package com.cats.cats.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    private HttpHeaders headers = new HttpHeaders();
        

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
    public ResponseEntity<String> addCat(@RequestBody CatModel cat) {
        catService.addCat(cat);

        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>("{\"message\": \"Cat deleted successfully\"}", headers, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<CatModel> updateCat(@PathVariable Long id, @RequestBody CatModel catModel) {
        CatModel updatedCat = catService.updateCat(id, catModel);
        return ResponseEntity.ok(updatedCat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCat(@PathVariable("id") Long id) {
        catService.deleteCatById(id);

        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>("{\"message\": \"Cat deleted successfully\"}", headers, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllCats() {
        catService.deleteAllCats();

        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>("{\"message\": \"All cats have been deleted\"}", headers, HttpStatus.OK);
    }
}
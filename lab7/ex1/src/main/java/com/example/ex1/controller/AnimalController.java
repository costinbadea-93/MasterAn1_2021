package com.example.ex1.controller;

import com.example.ex1.model.Animal;
import com.example.ex1.repository.AnimalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Animal>> retrieveAnimals(){
        return ResponseEntity.ok().body(
          animalRepository.findAll()
        );
    }

    @PostMapping("/new")
    public ResponseEntity<Animal> addNewAnimal(@RequestBody Animal animal){
        Animal savedAnimal = animalRepository.save(animal);
        return ResponseEntity.created(URI.create("new/" + animal.getId())).body(savedAnimal);
    }

    @DeleteMapping("/{animalId}")
    public ResponseEntity<Integer> deleteAnimalById(@PathVariable int animalId){
        return ResponseEntity.ok().body(animalRepository.deleteById(animalId));
    }
}

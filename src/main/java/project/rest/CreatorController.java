package project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.entity.Creator;
import project.repository.CreatorRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class CreatorController {

    @Autowired
    CreatorRepository creatorRepository;

    @PostMapping(value = "/creator")
    public void saveCreator(@RequestBody Creator creator){
        creatorRepository.save(creator);
    }

    @GetMapping(value = "/creator/all")
    public List<Creator> getAllCreators(){
        return creatorRepository.findAll();
    }

    @GetMapping(value = "/creator/{id}")
    public Optional<Creator> getCreatorById(@PathVariable Long id){
        return creatorRepository.findById(id);
    }

    @DeleteMapping(value = "/creator/{id}")
    public void deleteCreator(@PathVariable Long id){
        creatorRepository.deleteById(id);
    }
}

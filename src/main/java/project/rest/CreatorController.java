package project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.entity.Creator;
import project.mapper.CreatorMapper;
import project.repository.CreatorRepository;
import project.rest.model.CreatorDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CreatorController {

    @Autowired
    CreatorRepository creatorRepository;

    @PostMapping(value = "/creator")
    public void saveCreator(@RequestBody CreatorDTO creatorDTO) {
        creatorRepository.save(CreatorMapper.fromDTOToEntity(creatorDTO));
    }

    @GetMapping(value = "/creator/all")
    public List<CreatorDTO> getAllCreators() {
        return creatorRepository.findAll().stream().map(CreatorMapper::fromEntityToDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/creator/{id}")
    public Optional<Creator> getCreatorById(@PathVariable Long id) {
        return creatorRepository.findById(id);
    }

    @DeleteMapping(value = "/creator/{id}")
    public void deleteCreator(@PathVariable Long id) {
        creatorRepository.deleteById(id);
    }
}

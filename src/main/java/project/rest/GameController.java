package project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.entity.Creator;
import project.entity.Game;
import project.mapper.GameMapper;
import project.repository.CreatorRepository;
import project.repository.GameRepository;
import project.rest.model.GameDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    CreatorRepository creatorRepository;

    @PostMapping(value = "/game/save")
    public void saveGame(@RequestBody GameDTO gameDTO) {

        final Creator creatorFound = creatorRepository.findByName(gameDTO.getCreators().getName());
        if (creatorFound != null) {
            gameDTO.setCreators(creatorFound);
        } else {
            gameDTO.setCreators(creatorRepository.save(gameDTO.getCreators()));
        }
        GameMapper.fromEntityToDTO(gameRepository.save(GameMapper.fromDTOToEntity(gameDTO)));
    }

    @GetMapping(value = "/game/all")
    public List<GameDTO> getAllGames() {
        return gameRepository.findAll().stream().map(GameMapper::fromEntityToDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/game/{id}")
    public Optional<Game> getGameById(@PathVariable Long id) {
        return gameRepository.findById(id);
    }

    @PutMapping(value = "/game/{id}")
    public Game updateGame(@PathVariable Long id, @RequestBody Game newGame) {
        Game game = gameRepository.findById(id).get();
        if (newGame.getName() != null)
            game.setName(newGame.getName());
        if (newGame.getForAge() != null)
            game.setForAge(newGame.getForAge());
        if (newGame.getMultiplayer() != null)
            game.setMultiplayer(newGame.getMultiplayer());
        if (newGame.getSinglePlayer() != null)
            game.setSinglePlayer(newGame.getSinglePlayer());
        if (newGame.getGameGenre() != null)
            game.setGameGenre(newGame.getGameGenre());
        if (newGame.getCrossPlatform() != null)
            game.setCrossPlatform(newGame.getCrossPlatform());
        return gameRepository.save(game);
    }

    @DeleteMapping(value = "/game/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameRepository.deleteById(id);
    }
}

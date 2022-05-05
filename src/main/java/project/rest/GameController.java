package project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.entity.Creator;
import project.entity.Game;
import project.repository.CreatorRepository;
import project.repository.GameRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private CreatorRepository creatorRepository;

    @PostMapping(value = "/game/save")
    public void saveGame(@RequestBody Game game) {

        final Creator creatorFound = creatorRepository.findByName(game.getCreators().getName());
        if (creatorFound != null) {
            game.setCreators(creatorFound);
        } else {
            game.setCreators(creatorRepository.save(game.getCreators()));
        }
        gameRepository.save(game);
    }

    @GetMapping(value = "/game/all")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
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

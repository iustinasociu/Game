package project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.entity.Creator;
import project.entity.Game;
import project.repository.CreatorRepository;
import project.repository.GameRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private CreatorRepository creatorRepository;

//    @GetMapping(value = "/game/all")
//    public String getAllGames(Model model) {
//        model.addAttribute("games", gameRepository.findAll());
//        return "all-games";
//    }
//
//    @GetMapping(value = "/game/save")
//    public String saveGameForm(Model model) {
//        model.addAttribute("game", new Game());
//        return "add-games";
//    }
//
//    @PostMapping(value = "/game/save")
//    public String saveGame(@ModelAttribute("game") @RequestBody Game game, RedirectAttributes redirectAttributes) {
//        gameRepository.save(game);
//        redirectAttributes.addFlashAttribute("message", "The game has been saved successfully.");
//        return "redirect:/game/save";
//    }


    @PostMapping(value = "/game")
    public void saveGame(@RequestBody Game game) {

        final Creator creatorFound = creatorRepository.findByName(game.getCreators().getName());
        if(creatorFound != null){
            game.setCreators(creatorFound);
        }else{
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

    @DeleteMapping(value = "/game/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameRepository.deleteById(id);
    }
}

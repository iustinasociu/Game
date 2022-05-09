package project.mapper;

import project.entity.Game;
import project.rest.model.GameDTO;

public class GameMapper {

    public static Game fromDTOToEntity(GameDTO gameDTO) {
        return new Game(gameDTO.getName(), gameDTO.getForAge(), gameDTO.getMultiplayer(),
                gameDTO.getSinglePlayer(), gameDTO.getGameGenre(), gameDTO.getCrossPlatform(),
                gameDTO.getCreators());
    }

    public static GameDTO fromEntityToDTO(Game game) {
        return new GameDTO(game.getId(), game.getName(), game.getMultiplayer(),
                game.getSinglePlayer(),game.getGameGenre(),game.getCrossPlatform(), game.getCreators());
    }
}

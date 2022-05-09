package project.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.entity.Creator;
import project.entity.CrossPlatform;
import project.entity.GameGenre;

@Getter
@Setter
@NoArgsConstructor
public class GameDTO {

    private Long id;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String forAge;

    private Boolean multiplayer;

    private Boolean singlePlayer;

    private GameGenre gameGenre;

    private CrossPlatform crossPlatform;

    private Creator creators;

    public GameDTO(Long id, String name, Boolean multiplayer, Boolean singlePlayer, GameGenre gameGenre, CrossPlatform crossPlatform, Creator creators) {
        this.id = id;
        this.name = name;
        this.multiplayer = multiplayer;
        this.singlePlayer = singlePlayer;
        this.gameGenre = gameGenre;
        this.crossPlatform = crossPlatform;
        this.creators = creators;
    }

}

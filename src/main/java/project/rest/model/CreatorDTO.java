package project.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.entity.Game;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CreatorDTO {

    private Long id;

    private String name;

    private String nationality;

    private Set<Game> games;

    public CreatorDTO(Long id, String name, String nationality, Set<Game> games) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.games = games;
    }
}

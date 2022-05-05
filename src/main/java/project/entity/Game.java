package project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class Game {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    private String forAge;

    private Boolean multiplayer;

    private Boolean singlePlayer;

    @Enumerated(EnumType.STRING)
    private GameGenre gameGenre;

    @Enumerated(EnumType.STRING)
    private CrossPlatform crossPlatform;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name = "game_creator",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "creator_id"))
    private Creator creators;

}

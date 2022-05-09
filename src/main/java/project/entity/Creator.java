package project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
public class Creator {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    private String nationality;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creators")
    private Set<Game> games;

    public Creator(String name, String nationality, Set<Game> games) {
        this.name = name;
        this.nationality = nationality;
        this.games = games;
    }
}

package project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@ToString
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
}

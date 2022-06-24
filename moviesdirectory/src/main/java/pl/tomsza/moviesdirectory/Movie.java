package pl.tomsza.moviesdirectory;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Movie {

    @Id
    private UUID id;

    private String name;

    @ManyToOne
    private Category category;

    @ManyToMany
    private Set<Actor> actors;

    public Movie() {
        id = UUID.randomUUID();
    }


    public Movie(String name) {
        this();
        this.name = name;
    }
}

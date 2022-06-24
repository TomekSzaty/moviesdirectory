package pl.tomsza.moviesdirectory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@JsonIgnoreProperties(value = {"movies"})
public class Actor {

    @Id
    private UUID id;

    private String name;
    private String surname;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies;

}

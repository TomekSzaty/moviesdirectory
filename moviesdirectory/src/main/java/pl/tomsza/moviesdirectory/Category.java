package pl.tomsza.moviesdirectory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@JsonIgnoreProperties(value = {"movies"})
public class Category {
    @Id
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Movie> movies;
}

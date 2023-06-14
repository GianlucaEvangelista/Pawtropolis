package pawtropolis.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "species")
@Getter
@Setter
@NoArgsConstructor
public class SpeciesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NonNull
    private String name;
}

package pawtropolis.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "animals")
@Getter
@Setter
@NoArgsConstructor
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @NonNull
    private String name;
    @Column(name = "favourite_food")
    @NonNull
    private String favouriteFood;
    @Column(name = "age")
    @NonNull
    private Integer age;
    @Column(name = "arrival_date")
    @NonNull
    private LocalDate arrivalDate;
    @Column(name = "weight")
    @NonNull
    private Double weight;
    @Column(name = "height")
    @NonNull
    private Double height;
    @Column(name = "tail_length")
    private Double tailLength;
    @Column(name = "wingspan")
    private Double wingspan;
    @ManyToOne(targetEntity = SpeciesEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "species_id", referencedColumnName = "id")
    @NonNull
    private SpeciesEntity speciesEntity;
}


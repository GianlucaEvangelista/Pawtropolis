package pawtropolis.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

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
    @Column(name = "weight")
    @NonNull
    private Double weight;
    @Column(name = "height")
    @NonNull
    private Double height;
    @ManyToOne(targetEntity = SpeciesEntity.class)
    @PrimaryKeyJoinColumn(referencedColumnName = "id")
    @NonNull
    private SpeciesEntity speciesEntity;
}


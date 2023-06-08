package pawtropolis.persistance;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "animals")
@Getter
@Setter
@NoArgsConstructor
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "favourite_food")
    @NotNull
    private String favouriteFood;
    @Column(name = "age")
    @NotNull
    private Integer age;
    @Column(name = "weight")
    @NotNull
    private Double weight;
    @Column(name = "height")
    @NotNull
    private Double height;
    @ManyToOne(targetEntity = SpeciesEntity.class)
    @PrimaryKeyJoinColumn(referencedColumnName = "id")
    @NotNull
    private SpeciesEntity speciesEntity;
}


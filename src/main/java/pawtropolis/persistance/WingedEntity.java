package pawtropolis.persistance;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "wingspans")
@Getter
@Setter
@NoArgsConstructor
public class WingedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "wingspan")
    @NotNull
    private Double wingspan;
    @OneToMany(targetEntity = AnimalEntity.class)
    @PrimaryKeyJoinColumn(referencedColumnName = "id")
    @NotNull
    private AnimalEntity animalEntity;
}

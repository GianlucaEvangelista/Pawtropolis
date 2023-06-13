package pawtropolis.persistence.model;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "winged")
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
    private List<AnimalEntity> animalEntity;
}

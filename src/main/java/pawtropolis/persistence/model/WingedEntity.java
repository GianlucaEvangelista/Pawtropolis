package pawtropolis.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
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
    @NonNull
    private Double wingspan;
    @OneToMany(targetEntity = AnimalEntity.class)
    @PrimaryKeyJoinColumn(referencedColumnName = "id")
    @NonNull
    private List<AnimalEntity> animalEntity;
}

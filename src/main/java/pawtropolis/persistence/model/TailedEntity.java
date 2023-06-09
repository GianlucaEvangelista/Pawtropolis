package pawtropolis.persistence.model;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "tail_length")
@Getter
@Setter
@NoArgsConstructor
public class TailedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tail_length")
    @NotNull
    private Double tailLength;
    @OneToOne(targetEntity = AnimalEntity.class)
    @PrimaryKeyJoinColumn(referencedColumnName = "id")
    @NotNull
    private AnimalEntity animalEntity;
}

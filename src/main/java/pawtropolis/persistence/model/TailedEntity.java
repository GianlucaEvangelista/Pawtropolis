package pawtropolis.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "tailed")
@Getter
@Setter
@NoArgsConstructor
public class TailedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tail_length")
    @NonNull
    private Double tailLength;
    @OneToOne(targetEntity = AnimalEntity.class)
    @PrimaryKeyJoinColumn(referencedColumnName = "id")
    @NonNull
    private AnimalEntity animalEntity;
}

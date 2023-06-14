package pawtropolis.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NonNull
    private String name;
    @Column(name = "life_points")
    @NonNull
    private Integer lifePoints;
    @OneToOne(targetEntity = BagEntity.class)
    @PrimaryKeyJoinColumn(referencedColumnName = "id")
    @NonNull
    private BagEntity bagEntity;
}

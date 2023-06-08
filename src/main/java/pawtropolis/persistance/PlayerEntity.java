package pawtropolis.persistance;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

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
    @NotNull
    private String name;
    @Column(name = "life_points")
    @NotNull
    private Integer lifePoints;
    @OneToOne(targetEntity = BagEntity.class)
    @PrimaryKeyJoinColumn(referencedColumnName = "id")
    @NotNull
    private BagEntity bagEntity;
}

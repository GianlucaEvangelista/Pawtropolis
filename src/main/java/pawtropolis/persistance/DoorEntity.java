package pawtropolis.persistance;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "doors")
@Getter
@Setter
@NoArgsConstructor
public class DoorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "locked")
    @NotNull
    private Boolean locked;
    @OneToOne(targetEntity = ItemEntity.class)
    @PrimaryKeyJoinColumn(referencedColumnName = "id")
    @NotNull
    private ItemEntity keyItemEntity;
}

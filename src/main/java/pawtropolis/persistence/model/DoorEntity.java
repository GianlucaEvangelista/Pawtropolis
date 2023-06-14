package pawtropolis.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

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
    @NonNull
    private Boolean locked;
    @OneToOne(targetEntity = ItemEntity.class)
    @PrimaryKeyJoinColumn(referencedColumnName = "id")
    @NonNull
    private ItemEntity keyItemEntity;
}

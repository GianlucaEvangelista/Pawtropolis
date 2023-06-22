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
    private Integer id;
    @Column(name = "locked")
    @NonNull
    private Boolean locked;
    @OneToOne(targetEntity = ItemEntity.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private ItemEntity keyItemEntity;
}

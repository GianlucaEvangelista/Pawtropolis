package pawtropolis.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "bags")
@Getter
@Setter
@NoArgsConstructor
public class BagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "available_slots")
    @NonNull
    private Integer availableSlots;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "items_in_bag",
            joinColumns = @JoinColumn(name = "bag_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> itemEntities;
}

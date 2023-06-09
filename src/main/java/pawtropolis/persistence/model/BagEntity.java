package pawtropolis.persistence.model;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bags")
@Getter
@Setter
@NoArgsConstructor
public class BagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "available_slots")
    @NotNull
    private Integer availableSlots;
    @ManyToMany
    @JoinTable(
            name = "items_in_bag",
            joinColumns = @JoinColumn(name = "bag_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> itemEntities;
}

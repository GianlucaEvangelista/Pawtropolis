package pawtropolis.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @NonNull
    private String name;
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "items_in_room",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
            )
    private List<ItemEntity> itemEntities;
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "animals_in_room",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "animal_id")
    )
    private List<AnimalEntity> animalEntities;
}

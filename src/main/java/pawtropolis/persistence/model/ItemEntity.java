package pawtropolis.persistence.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NonNull
    private String name;
    @Column(name = "description")
    @NonNull
    private String description;
    @Column(name = "required_slots")
    @NonNull
    private Integer requiredSlots;
    @ManyToMany(mappedBy = "items")
    private List<BagEntity> bagEntity;
    @ManyToMany(mappedBy = "items")
    private List<RoomEntity> roomEntity;
}

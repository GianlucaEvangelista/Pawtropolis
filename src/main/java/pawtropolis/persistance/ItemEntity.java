package pawtropolis.persistance;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "Items")
@Getter
@Setter
@NoArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "description")
    @NotNull
    private String description;
    @Column(name = "required_slots")
    @NotNull
    private Integer requiredSlots;
    @ManyToMany(mappedBy = "items")
    private BagEntity bagEntity;
    @ManyToMany(mappedBy = "items")
    private RoomEntity roomEntity;
}

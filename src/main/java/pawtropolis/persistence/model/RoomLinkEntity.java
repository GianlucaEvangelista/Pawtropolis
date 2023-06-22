package pawtropolis.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room_links")
@Getter
@Setter
@NoArgsConstructor
public class RoomLinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "adjacent_room_id")
    private RoomEntity adjacentRoom;

    @ManyToOne
    @JoinColumn(name = "door_id")
    private DoorEntity door;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private DirectionEntity direction;

}

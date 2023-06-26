package pawtropolis.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pawtropolis.persistence.model.BagEntity;
import java.util.List;

public interface BagRepository extends JpaRepository<BagEntity, Integer> {

    @Query(value = "SELECT item_id FROM items_in_bag WHERE bag_id = (SELECT id FROM bags WHERE id = :bagId)", nativeQuery = true)
    List<Integer> getItemsIdFromBag(@Param("bagId") Integer bagId);

    @Query(value = "SELECT item_id FROM items_in_bag WHERE bag_id = (SELECT id FROM bags WHERE id = :bagId) AND item_id = (SELECT id FROM items WHERE name = :itemName)", nativeQuery = true)
    Integer getItemIdFromBag(@Param("bagId") Integer bagId, @Param("itemName") String itemName);
}

package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.game.model.Bag;
import pawtropolis.persistence.marshaller.BagMarshaller;
import pawtropolis.persistence.model.BagEntity;
import pawtropolis.persistence.repository.BagRepository;

@Service
public class BagService {

    private final BagRepository bagRepository;

    private final BagMarshaller bagMarshaller;

    @Autowired
    public BagService(BagRepository bagRepository, BagMarshaller bagMarshaller) {
        this.bagRepository = bagRepository;
        this.bagMarshaller = bagMarshaller;
    }

    public Bag getBagById(int id) {
        BagEntity bagEntity = bagRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        return bagMarshaller.toBag(bagEntity);
    }

    public BagEntity saveBag(Bag bag) {
        return bagRepository.save(bagMarshaller.toBagEntity(bag));
    }
}

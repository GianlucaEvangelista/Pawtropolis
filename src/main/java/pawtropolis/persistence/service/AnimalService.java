package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.persistence.marshaller.AnimalMarshaller;
import pawtropolis.persistence.model.AnimalEntity;
import pawtropolis.persistence.repository.AnimalRepository;
import pawtropolis.zoo.model.Animal;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalMarshaller animalMarshaller;
    @Autowired
    public AnimalService(AnimalRepository animalRepository, AnimalMarshaller animalMarshaller) {
        this.animalRepository = animalRepository;
        this.animalMarshaller = animalMarshaller;
    }
    public <T extends Animal> T getAnimalById(int id) {
        AnimalEntity animalEntity = animalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Animal not found"));

        return animalMarshaller.toAnimal(animalEntity);
    }
}

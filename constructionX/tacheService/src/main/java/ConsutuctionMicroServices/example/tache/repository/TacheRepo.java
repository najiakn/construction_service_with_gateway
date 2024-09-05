package ConsutuctionMicroServices.example.tache.repository;

import ConsutuctionMicroServices.example.tache.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepo extends JpaRepository<Tache, Integer> {


    List<Tache> findTachesByIdProjet(int idProjet);
}

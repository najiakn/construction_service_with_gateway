package ConsutuctionMicroServices.example.ressourceService.repository;

import ConsutuctionMicroServices.example.ressourceService.model.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RessourceRepo extends JpaRepository<Ressource,Integer> {
    List<Ressource> findRessourcesByIdTache(int idTache);



}

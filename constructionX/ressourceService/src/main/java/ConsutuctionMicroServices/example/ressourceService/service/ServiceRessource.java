package ConsutuctionMicroServices.example.ressourceService.service;


import ConsutuctionMicroServices.example.ressourceService.model.Ressource;
import ConsutuctionMicroServices.example.ressourceService.repository.RessourceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/ressources")
public class ServiceRessource {
@Autowired
    private  RessourceRepo ressourceRepo;
    public  void saveRessource(Ressource ressource){
        ressourceRepo.save(ressource);

    }
    public List<Ressource> findAllRessource(){
        return ressourceRepo.findAll();
    }

    public  Ressource getRessourceById(int id){
        Optional<Ressource> ressource = ressourceRepo.findById(id);
        return ressource.get();
    }

    public Ressource editRessources(int id, Ressource ressources) {
        Optional<Ressource> edited = ressourceRepo.findById(id);
        Ressource saved = edited.get();
        saved.setIdr(id);
        saved.setNom(ressources.getNom());
        saved.setQuantite(ressources.getQuantite());
        saved.setType(ressources.getType());

        return ressourceRepo.save(saved);
    }

    public List<Ressource> getAllRessources() {
        return ressourceRepo.findAll();
    }

    public void deleteRessources(int id) {
        ressourceRepo.deleteById(id);
    }


    public List<Ressource> getRessourcesByTache(int id) {

        return ressourceRepo.findRessourcesByIdTache(id);
    }

    public void deleteRessourcesWithTache(int id) {
        List<Ressource> ressources = ressourceRepo.findRessourcesByIdTache(id);
        ressourceRepo.deleteAll(ressources);
    }

}




package ConsutuctionMicroServices.example.tache.service;

import ConsutuctionMicroServices.example.tache.client.*;
import ConsutuctionMicroServices.example.tache.model.Tache;
import ConsutuctionMicroServices.example.tache.repository.TacheRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceTache {
@Autowired
    private  TacheRepo tacheRepo;
@Autowired
private ProjetInterface projetInterface;
@Autowired
    RessourcesClient ressourcesClient;

    public  void saveTache(Tache tache,int idProjet ){
        try {
            ProjetResponse projetResponse = projetInterface.getProjetById(idProjet);
            // Assure-toi que projetResponse n'est pas nul ici
            if (projetResponse == null) {
                throw new IllegalArgumentException("Projet non trouvé : ID " + idProjet);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Erreur lors de la récupération du projet : " + e.getMessage());
        }
        tacheRepo.save(tache);

    }
    public List<Tache>findAllTaches(){
        return tacheRepo.findAll();
    }


    public Tache update( int id , Tache tache) {
        Optional<Tache> tacheOptional = tacheRepo.findById(id);
        if (tacheOptional.isPresent()) {

            Tache tache1 = tacheOptional.get();
            tache1.setDescription(tache1.getDescription());
            tache1.setStatus(tache1.getStatus());
            tache1.setDate_debut(tache1.getDate_debut());
            tache1.setDate_fin(tache1.getDate_fin());
            tache1.setIdProjet(tache1.getIdProjet());
            Tache updateTache= tacheRepo.save(tache);

            return updateTache;
        }
        else  {

            throw new EntityNotFoundException("Projet not found with id: " + id);
        }
    }


    public void deleteTaches(int id) {
        ressourcesClient.deleteRessourcesByTache(id);
        tacheRepo.deleteById(id);
    }

    public void deleteAllTacheOfProjet(int id) {
        List<Tache> taches = tacheRepo.findTachesByIdProjet(id);
        tacheRepo.deleteAll(taches);
    }

    public FullTachesResponse tachWithRessources(int id) {
        Tache tache = tacheRepo.findById(id).orElse(
                Tache.builder()
                        .description("NOT_FOUND")
                        .build()
        );
        List<Ressources> ressources = ressourcesClient.getRessourcesByTache(id);
        return FullTachesResponse.builder()
                .description(tache.getDescription())
                .dateDebut(tache.getDate_debut())
                .dateFin(tache.getDate_fin())
                .statut(tache.getStatus())
                .ressources(ressources)
                .build();
    }


    public List<Tache> getAllTachesByProjet(int id) {
        return tacheRepo.findTachesByIdProjet(id);
    }

}

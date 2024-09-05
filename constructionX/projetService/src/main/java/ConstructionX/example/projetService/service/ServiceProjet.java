package ConstructionX.example.projetService.service;


import ConstructionX.example.projetService.client.TachesClient;

import ConstructionX.example.projetService.exception.ProjetNotFoundException;
import ConstructionX.example.projetService.model.FullProjetResponse;
import ConstructionX.example.projetService.model.Projet;
import ConstructionX.example.projetService.model.Taches;
import ConstructionX.example.projetService.repository.ProjetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceProjet {

    @Autowired
    private  ProjetRepository projetRepository;

    @Autowired
    TachesClient tachesClient;

    public  void saveProjet(Projet projet){
        projetRepository.save(projet);

    }
    public List<Projet>findAllProjets(){
        try{

        return projetRepository.findAll();
    } catch (Exception e) {
        throw new IllegalStateException("Erreur lors de la suppression des tâches pour l'ID du projet : " );
    }
}


    public Projet getProjetById(int id) {
        return projetRepository.findById(id)
                .orElseThrow(() -> new ProjetNotFoundException("Projet with ID " + id + " not found."));
    }




    public Projet update( int id , Projet projet) {
        Optional<Projet> projetOptional = projetRepository.findById(id);
        if (projetOptional.isPresent()) {

            Projet projet1 = projetOptional.get();
            projet1.setNom_projet(projet1.getNom_projet());
            projet1.setDescription_projet(projet1.getDescription_projet());
            projet1.setBudget(projet1.getBudget());
            projet1.setDate_fin(projet1.getDate_fin());
            projet1.setDate_debut(projet1.getDate_debut());
            Projet updateProjet = projetRepository.save(projet);

            return updateProjet;
        }
        else  {

            throw new EntityNotFoundException("Projet not found with id: " + id);
        }
    }

    public FullProjetResponse projetWithTaches(int id) {
        Projet projet = projetRepository.findById(id)
                .orElse(
                        Projet.builder()
                                .nom_projet("NOT_FOUND")
                                .build()
                );
        List<Taches> taches = tachesClient.findAllTachesByProjet(id);
        return FullProjetResponse.builder()
                .nom(projet.getNom_projet())
                .dateDebut(projet.getDate_debut())
                .dateFin(projet.getDate_fin())
                .description(projet.getDescription_projet())
                .budget(projet.getBudget())
                .taches(taches)
                .build();
    }


    public void supprimerProjet(int id) {
        tachesClient.deleteTacheWithProjet(id);
        projetRepository.deleteById(id);
    }
}

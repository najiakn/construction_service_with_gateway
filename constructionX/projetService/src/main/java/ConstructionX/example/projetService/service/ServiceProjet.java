package ConstructionX.example.projetService.service;


import ConstructionX.example.projetService.model.Projet;
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

    public  void saveProjet(Projet projet){
        projetRepository.save(projet);

    }
    public List<Projet>findAllProjets(){
        return projetRepository.findAll();
    }


    public  Projet getprojetById(int id){
        Optional<Projet> projet = projetRepository.findById(id);
        return projet.get();
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


    public  void delete (int id ){
        projetRepository.deleteById(id);
    }
}

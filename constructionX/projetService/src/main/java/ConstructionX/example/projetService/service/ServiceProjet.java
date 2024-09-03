package ConstructionX.example.projetService.service;


import ConstructionX.example.projetService.model.Projet;
import ConstructionX.example.projetService.repository.ProjetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceProjet {

    private final ProjetRepository projetRepository;
    public  void saveProjet(Projet projet){
        projetRepository.save(projet);

    }
    public List<Projet>findAllProjets(){
        return projetRepository.findAll();
    }
}

package ConstructionX.example.projetService.service;


import ConstructionX.example.projetService.model.Projet;
import ConstructionX.example.projetService.repository.ProjetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

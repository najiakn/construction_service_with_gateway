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
}




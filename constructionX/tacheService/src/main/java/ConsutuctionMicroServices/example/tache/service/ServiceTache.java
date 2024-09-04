package ConsutuctionMicroServices.example.tache.service;

import ConsutuctionMicroServices.example.tache.model.Tache;
import ConsutuctionMicroServices.example.tache.repository.TacheRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ServiceTache {
@Autowired
    private  TacheRepo tacheRepo;
    public  void saveTache(Tache tache){
        tacheRepo.save(tache);

    }
    public List<Tache>findAllTaches(){
        return tacheRepo.findAll();
    }
}

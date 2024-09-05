package ConsutuctionMicroServices.example.tache.controller;

import ConsutuctionMicroServices.example.tache.client.FullTachesResponse;
import ConsutuctionMicroServices.example.tache.model.Tache;
import ConsutuctionMicroServices.example.tache.service.ServiceTache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taches")
public class TacheController {
    @Autowired
    private ServiceTache serviceTache;


    @PostMapping("/{idProjet}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Tache tache, @PathVariable int idProjet) {
        serviceTache.saveTache(tache,idProjet);
    }

    @GetMapping
    public ResponseEntity<List<Tache>>findAllTaches(){return ResponseEntity.ok(serviceTache
            .findAllTaches());}


    @PutMapping("/{id}")
    public ResponseEntity<Tache>update(@PathVariable("id") int id , @RequestBody Tache tache){
        Tache updateTache=serviceTache.update(id,tache);
        if(updateTache!=null){
            return ResponseEntity.ok(updateTache);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/projet/{id}")
    public List<Tache> tachesOfProjet(@PathVariable int id){
        return serviceTache.getAllTachesByProjet(id);
    }

    @GetMapping("/{id}")
    public FullTachesResponse tachesWithRessources(@PathVariable int id){
        return serviceTache.tachWithRessources(id);
    }

    @DeleteMapping("/projet/delete/{id}")
    public void deleteTachesOfProjet(@PathVariable int id){

        serviceTache.deleteAllTacheOfProjet(id);
    }


}


package ConsutuctionMicroServices.example.ressourceService.controller;

import ConsutuctionMicroServices.example.ressourceService.model.Ressource;
import ConsutuctionMicroServices.example.ressourceService.service.ServiceRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ressources")
public class ressourceController {


    @Autowired
    private ServiceRessource serviceRessource;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Ressource ressource) {
        serviceRessource.saveRessource(ressource);
    }

    @GetMapping
    public ResponseEntity<List<Ressource>> findAllRessource(){return ResponseEntity.ok(serviceRessource.findAllRessource());}

    @GetMapping("/{id}")
    public ResponseEntity<Ressource> getRessourceById(@PathVariable("id") int id) {
        Ressource ressource = serviceRessource.getRessourceById(id);
        if (ressource != null) {
            return ResponseEntity.ok(ressource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public Ressource editRessource(@PathVariable int id, @RequestBody Ressource ressources){
        return serviceRessource.editRessources(id, ressources);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        serviceRessource.deleteRessources(id);
    }

    @DeleteMapping("tache/{id}")
    public void deleteRessourcesOfTache(@PathVariable int id){
        serviceRessource.deleteRessourcesWithTache(id);
    }
}




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
}


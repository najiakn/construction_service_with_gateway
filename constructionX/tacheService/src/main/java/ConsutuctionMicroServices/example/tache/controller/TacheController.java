package ConsutuctionMicroServices.example.tache.controller;

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


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Tache tache) {
        serviceTache.saveTache(tache);
    }

    @GetMapping
    public ResponseEntity<List<Tache>>findAllTaches(){return ResponseEntity.ok(serviceTache
            .findAllTaches());}
}


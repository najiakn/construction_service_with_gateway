package ConstructionX.example.projetService.Controller;

import ConstructionX.example.projetService.model.Projet;
import ConstructionX.example.projetService.service.ServiceProjet;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/projets")
public class  ProjetController {

    @Autowired
    private ServiceProjet serviceProjet;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Projet projet) {
          serviceProjet.saveProjet(projet);
    }
    @GetMapping
    public ResponseEntity<List<Projet>>findAllProjets(){
        return ResponseEntity.ok(serviceProjet.findAllProjets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable("id") int id) {
        Projet projet = serviceProjet.getprojetById(id);
        if (projet != null) {
            return ResponseEntity.ok(projet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



package ConstructionX.example.projetService.Controller;

import ConstructionX.example.projetService.exception.ProjetNotFoundException;
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
    public ResponseEntity<List<Projet>> findAllProjets() {
        return ResponseEntity.ok(serviceProjet.findAllProjets());
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Projet> getProjetById(@PathVariable("id") int id) {
//        Projet projet = serviceProjet.getprojetById(id);
//        if (projet != null) {
//            return ResponseEntity.ok(projet);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProjetById(@PathVariable("id") int id) {
        try {
            Projet projet = serviceProjet.getProjetById(id);
            return ResponseEntity.ok(projet);
        } catch (ProjetNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Projet>update(@PathVariable("id") int id , @RequestBody Projet projet){
        Projet updteProjet=serviceProjet.update(id,projet);
        if(updteProjet!=null){
            return ResponseEntity.ok(updteProjet);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        serviceProjet.supprimerProjet(id);
        return ResponseEntity.noContent().build();
    }
}



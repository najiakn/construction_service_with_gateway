package ConstructionX.example.projetService.Controller;

import ConstructionX.example.projetService.model.Projet;
import ConstructionX.example.projetService.service.ServiceProjet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProjetController {

    private ServiceProjet serviceProjet;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Projet projet) {
          serviceProjet.saveProjet(projet);
    }

}



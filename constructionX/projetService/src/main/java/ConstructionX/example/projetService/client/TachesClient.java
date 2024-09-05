package ConstructionX.example.projetService.client;

import ConstructionX.example.projetService.model.Taches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "tache-service", url = "${application.config.taches-url}")
public interface TachesClient {

    @GetMapping("/projet/{id}")
    List<Taches> findAllTachesByProjet(@PathVariable int id);
    @DeleteMapping("/projet/delete/{id}")
    List<Taches> deleteTacheWithProjet(@PathVariable int id);
}

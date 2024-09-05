package ConsutuctionMicroServices.example.tache.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ressource-service", url = "${application.config.ressources-url}")
public interface RessourcesClient {
    @GetMapping("{id}")
    List<Ressources> getRessourcesByTache(@PathVariable int id);
    @DeleteMapping("tache/{id}")
    void deleteRessourcesByTache(@PathVariable int id);
}

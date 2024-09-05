package ConsutuctionMicroServices.example.tache.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "projet-service", url = "http://localhost:8020/api/projets")
public interface ProjetInterface {



        @GetMapping("/{id}")
        ProjetResponse getProjetById(@PathVariable("id") int id) ;

}

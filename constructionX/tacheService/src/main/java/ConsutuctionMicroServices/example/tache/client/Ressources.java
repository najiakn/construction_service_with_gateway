package ConsutuctionMicroServices.example.tache.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ressources {
    private String nom;
    private String type;
    private  String quantite;

}

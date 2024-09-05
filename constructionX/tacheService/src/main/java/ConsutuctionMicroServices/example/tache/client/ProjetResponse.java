package ConsutuctionMicroServices.example.tache.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetResponse {

    private int id ;
    private String nom_projet;
    private String description_projet;
    private Date date_debut;
    private Date date_fin;
    private float budget;
}

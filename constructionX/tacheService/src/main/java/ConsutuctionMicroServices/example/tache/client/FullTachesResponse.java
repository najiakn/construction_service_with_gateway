package ConsutuctionMicroServices.example.tache.client;

import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullTachesResponse {
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String statut;
    private List<Ressources> ressources;
}

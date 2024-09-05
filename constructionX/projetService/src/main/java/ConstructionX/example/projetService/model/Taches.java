package ConstructionX.example.projetService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Taches {
    private String description;
    private java.util.Date date_debut;
    private Date date_fin;
    private String status;

}

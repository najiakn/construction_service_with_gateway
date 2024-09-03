package ConstructionX.example.projetService.repository;

import ConstructionX.example.projetService.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet,Integer> {
}

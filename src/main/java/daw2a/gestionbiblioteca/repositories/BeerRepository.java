package daw2a.gestionbiblioteca.repositories;

import daw2a.gestionbiblioteca.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    //segun volumen de alcoohol
    List<Beer> findByAbvGreaterThan(Float abv);
    //segun nombre
    List<Beer> findByNameContainingIgnoreCase(String name);
}

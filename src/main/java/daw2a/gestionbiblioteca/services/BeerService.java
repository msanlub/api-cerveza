package daw2a.gestionbiblioteca.services;

import daw2a.gestionbiblioteca.entities.Beer;
import daw2a.gestionbiblioteca.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeerService {
    private final BeerRepository beerRepository;

    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    public Beer getBeerById(Long id) {
        return beerRepository.findById(id).orElseThrow(() -> new RuntimeException("Beer not found"));
    }

    public Beer saveBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    public void deleteBeer(Long id) {
        beerRepository.deleteById(id);
    }

    //segun volumen de alcohol
    public List<Beer> findBeersWithAbvGreaterThan(Float abv) {
        return beerRepository.findByAbvGreaterThan(abv);
    }

    //segun nombre
    public List<Beer> findBeersByNameContaining(String name) {
        return beerRepository.findByNameContainingIgnoreCase(name);
    }
}
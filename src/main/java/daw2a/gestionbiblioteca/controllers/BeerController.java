package daw2a.gestionbiblioteca.controllers;

import daw2a.gestionbiblioteca.entities.Beer;
import daw2a.gestionbiblioteca.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beers")
@RequiredArgsConstructor
public class BeerController {
    private final BeerService beerService;

    @GetMapping
    public List<Beer> getAllBeers() {
        return beerService.getAllBeers();
    }

    @GetMapping("/{id}")
    public Beer getBeerById(@PathVariable Long id) {
        return beerService.getBeerById(id);
    }

    @PostMapping
    public Beer createBeer(@RequestBody Beer beer) {
        return beerService.saveBeer(beer);
    }

    @PutMapping("/{id}")
    public Beer updateBeer(@PathVariable Long id, @RequestBody Beer beer) {
        beer.setId(id);
        return beerService.saveBeer(beer);
    }

    @DeleteMapping("/{id}")
    public void deleteBeer(@PathVariable Long id) {
        beerService.deleteBeer(id);
    }

    //segun volumen de alcohol
    @GetMapping("/abv")
    public List<Beer> getBeersByAbv(@RequestParam Float minAbv) {
        return beerService.findBeersWithAbvGreaterThan(minAbv);
    }

    //segun nombre
    @GetMapping("/search")
    public List<Beer> searchBeersByName(@RequestParam String name) {
        return beerService.findBeersByNameContaining(name);
    }
}
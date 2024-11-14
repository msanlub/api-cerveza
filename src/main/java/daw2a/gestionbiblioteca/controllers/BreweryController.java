package daw2a.gestionbiblioteca.controllers;

import daw2a.gestionbiblioteca.entities.Brewery;
import daw2a.gestionbiblioteca.services.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breweries")
public class BreweryController {

    private final BreweryService breweryService;

    @Autowired
    public BreweryController(BreweryService breweryService) {
        this.breweryService = breweryService;
    }

    // CRUD endpoints
    @GetMapping
    public List<Brewery> getAllBreweries() {
        return breweryService.getAllBreweries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brewery> getBreweryById(@PathVariable Long id) {
        Brewery brewery = breweryService.getBreweryById(id);
        return ResponseEntity.ok(brewery);
    }

    @PostMapping
    public ResponseEntity<Brewery> createBrewery(@RequestBody Brewery brewery) {
        Brewery newBrewery = breweryService.createBrewery(brewery);
        return ResponseEntity.ok(newBrewery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brewery> updateBrewery(@PathVariable Long id, @RequestBody Brewery breweryDetails) {
        Brewery updatedBrewery = breweryService.updateBrewery(id, breweryDetails);
        return ResponseEntity.ok(updatedBrewery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrewery(@PathVariable Long id) {
        breweryService.deleteBrewery(id);
        return ResponseEntity.ok().build();
    }

    // por nombre y por ciudad
    @GetMapping("/search")
    public List<Brewery> searchBreweries(@RequestParam(required = false) String name,
                                         @RequestParam(required = false) String city) {
        if (name != null && !name.isEmpty()) {
            return breweryService.findBreweriesByName(name);
        } else if (city != null && !city.isEmpty()) {
            return breweryService.findBreweriesByCity(city);
        } else {
            return breweryService.getAllBreweries();
        }
    }
}

package daw2a.gestionbiblioteca.services;

import daw2a.gestionbiblioteca.entities.Brewery;
import daw2a.gestionbiblioteca.repositories.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BreweryService {

    private final BreweryRepository breweryRepository;

    @Autowired
    public BreweryService(BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }

    // CRUD operations
    public List<Brewery> getAllBreweries() {
        return breweryRepository.findAll();
    }

    public Brewery getBreweryById(Long id) {
        return breweryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brewery not found with id: " + id));
    }

    public Brewery createBrewery(Brewery brewery) {
        return breweryRepository.save(brewery);
    }

    public Brewery updateBrewery(Long id, Brewery breweryDetails) {
        Brewery brewery = getBreweryById(id);
        brewery.setName(breweryDetails.getName());
        brewery.setAddress1(breweryDetails.getAddress1());
        brewery.setAddress2(breweryDetails.getAddress2());
        brewery.setCity(breweryDetails.getCity());
        brewery.setState(breweryDetails.getState());
        brewery.setCode(breweryDetails.getCode());
        brewery.setCountry(breweryDetails.getCountry());
        brewery.setPhone(breweryDetails.getPhone());
        brewery.setWebsite(breweryDetails.getWebsite());
        brewery.setFilepath(breweryDetails.getFilepath());
        brewery.setDescript(breweryDetails.getDescript());
        brewery.setAddUser(breweryDetails.getAddUser());
        brewery.setLastMod(breweryDetails.getLastMod());
        return breweryRepository.save(brewery);
    }

    public void deleteBrewery(Long id) {
        breweryRepository.deleteById(id);
    }

    // por nombre
    public List<Brewery> findBreweriesByName(String name) {
        return breweryRepository.findByNameContainingIgnoreCase(name);
    }

    //por ciudad
    public List<Brewery> findBreweriesByCity(String city) {
        return breweryRepository.findByCityContainingIgnoreCase(city);
    }
}

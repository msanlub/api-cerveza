package daw2a.gestionbiblioteca.services;
import daw2a.gestionbiblioteca.entities.Style;

import daw2a.gestionbiblioteca.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StyleService {

    private final StyleRepository styleRepository;

    @Autowired
    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    // CRUD operations
    public List<Style> getAllStyles() {
        return styleRepository.findAll();
    }

    public Style getStyleById(Long id) {
        return styleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Style not found with id: " + id));
    }

    public Style createStyle(Style style) {
        return styleRepository.save(style);
    }

    public Style updateStyle(Long id, Style styleDetails) {
        Style style = getStyleById(id);
        style.setCatId(styleDetails.getCatId());
        style.setStyleName(styleDetails.getStyleName());
        style.setLastMod(styleDetails.getLastMod());
        return styleRepository.save(style);
    }

    public void deleteStyle(Long id) {
        styleRepository.deleteById(id);
    }

    //por nombre
    public List<Style> findStylesByName(String name) {
        return styleRepository.findByStyleNameContainingIgnoreCase(name);
    }
}
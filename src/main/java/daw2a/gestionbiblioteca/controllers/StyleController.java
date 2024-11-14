package daw2a.gestionbiblioteca.controllers;
import daw2a.gestionbiblioteca.entities.Style;
import daw2a.gestionbiblioteca.services.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/styles")
public class StyleController {

    private final StyleService styleService;

    @Autowired
    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    // CRUD endpoints
    @GetMapping
    public List<Style> getAllStyles() {
        return styleService.getAllStyles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Style> getStyleById(@PathVariable Long id) {
        Style style = styleService.getStyleById(id);
        return ResponseEntity.ok(style);
    }

    @PostMapping
    public ResponseEntity<Style> createStyle(@RequestBody Style style) {
        Style newStyle = styleService.createStyle(style);
        return ResponseEntity.ok(newStyle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Style> updateStyle(@PathVariable Long id, @RequestBody Style styleDetails) {
        Style updatedStyle = styleService.updateStyle(id, styleDetails);
        return ResponseEntity.ok(updatedStyle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStyle(@PathVariable Long id) {
        styleService.deleteStyle(id);
        return ResponseEntity.ok().build();
    }

    //por nombre
    @GetMapping("/search")
    public List<Style> searchStyles(@RequestParam String name) {
        return styleService.findStylesByName(name);
    }
}

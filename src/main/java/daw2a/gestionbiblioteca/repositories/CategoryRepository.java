package daw2a.gestionbiblioteca.repositories;

import daw2a.gestionbiblioteca.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByCatNameContainingIgnoreCase(String catName);
}
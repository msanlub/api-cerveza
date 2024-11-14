package daw2a.gestionbiblioteca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cat_name")
    private String catName;

    @Column(name = "last_mod")
    private LocalDateTime lastMod;

    @OneToMany(mappedBy = "category")
    private List<Beer> beers;

    @OneToMany(mappedBy = "category")
    private List<Style> styles;
}
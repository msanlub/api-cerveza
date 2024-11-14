package daw2a.gestionbiblioteca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "styles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cat_id")
    private Integer catId;

    @Column(name = "style_name")
    private String styleName;

    @Column(name = "last_mod")
    private LocalDateTime lastMod;

    @ManyToOne
    @JoinColumn(name = "cat_id", insertable = false, updatable = false)
    private Category category;

    @OneToMany(mappedBy = "style")
    private List<Beer> beers;
}
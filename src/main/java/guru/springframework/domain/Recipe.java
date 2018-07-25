package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author zhaozh
 * @version 1.0
 * @date 2018-7-24 16:31
 **/
@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servingTime;
    private String source;
    private String url;
    private String directions;
    @Lob
    private Byte[] img;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

}

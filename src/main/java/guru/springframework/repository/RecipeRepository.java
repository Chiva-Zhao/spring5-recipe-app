package guru.springframework.repository;

import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhaozh
 * @version 1.0
 * @date 2018-7-25 12:53
 **/
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}

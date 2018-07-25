package guru.springframework.repository;

import guru.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhaozh
 * @version 1.0
 * @date 2018-7-25 12:54
 **/
public interface CategoryRepository extends CrudRepository<Category, Long> {
}

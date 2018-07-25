package guru.springframework.controller;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repository.CategoryRepository;
import guru.springframework.repository.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author zhaozh
 * @version 1.0
 * @date 2018-7-25 14:29
 **/
@Controller
@Slf4j
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"/", "", "/index"})
    public String index() {
        Optional<Category> category = categoryRepository.findByDescription("Chinese");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Cup");
        log.info("Cat ID: " + category.get().getId());
        log.error("UOM ID:" + unitOfMeasure.get().getId());
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().iterator().forEachRemaining(categories::add);
        log.info(categories.toString());
        return "index";
    }
}

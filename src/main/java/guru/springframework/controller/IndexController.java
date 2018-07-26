package guru.springframework.controller;

import guru.springframework.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaozh
 * @version 1.0
 * @date 2018-7-25 14:29
 **/
@Controller
@Slf4j
public class IndexController {
    private RecipeRepository recipeRepository;

    public IndexController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"/", "", "/index"})
    public String index(Model model) {
        model.addAttribute("receip", recipeRepository.findById(1l));
        return "index";
    }
}

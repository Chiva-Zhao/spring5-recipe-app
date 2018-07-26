package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class IndexControllerTest1 {
    private IndexController controller;
    @Mock
    private RecipeService service;
    @Mock
    private Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(service);
    }

    @Test
    public void getIndexPage() {
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        Recipe recipe = new Recipe();
        recipe.setDescription("hello");
        recipes.add(recipe);
        when(service.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> captor = ArgumentCaptor.forClass(Set.class);
        String rst = controller.getIndexPage(model);
        assertEquals(rst, "index");
        verify(model, times(1)).addAttribute(eq("recipes"), captor.capture());
        verify(service, times(1)).getRecipes();
        Set<Recipe> captored = captor.getValue();
        assertEquals(2, captored.size());
    }
}
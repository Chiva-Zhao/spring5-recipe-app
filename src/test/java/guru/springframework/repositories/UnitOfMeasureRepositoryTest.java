package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repository.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTest {

    @Autowired
    private UnitOfMeasureRepository repository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() {
        Optional<UnitOfMeasure> rst = repository.findByDescription("Teaspoon");
        assertEquals("Teaspoon", rst.get().getDescription());
    }

    @Test
    @DirtiesContext
    public void findByDescription_cup() {
        Optional<UnitOfMeasure> rst = repository.findByDescription("Cup");
        assertEquals("Cup", rst.get().getDescription());
    }
}
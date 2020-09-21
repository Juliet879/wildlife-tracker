package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Lion");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void animal_getsNameOfAnimalCorrectly_String() {
        Animal testAnimal = new Animal("Lion");
        assertEquals("Lion", testAnimal.getName());
    }

}
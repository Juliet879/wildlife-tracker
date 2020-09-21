package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Rule
    public  DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiateCorrectly_true(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion");
        assertEquals(true,testAnimal instanceof EndangeredAnimal);

    }
    @Test
    public void animal_getNameInstantiateCorrectly_String(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion");
        assertEquals("Lion",testAnimal.getName());
    }
    @Test
    public void animal_instantiateWithCorrectType_String(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion");
        assertEquals("Lion",testAnimal.getType);
    }

}
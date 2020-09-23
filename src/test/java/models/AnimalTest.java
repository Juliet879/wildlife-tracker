package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    @Test
    public void animal_instantiateWithCorrectType_String(){
        Animal testAnimal = new Animal("Lion");
        assertEquals("animal",testAnimal.getType());
    }


    @Test
    public void equals_returnTrueWhenObjectsHaveSameValues_true(){
        Animal testAnimal = new Animal("Lion");
        Animal testAnimal2 = new Animal("Elephant");
        assertTrue(!testAnimal.equals(testAnimal2));
    }

    @Test
    public void save_addAnimalToDatabase_void(){
        Animal testAnimal = new Animal("Lion");
         testAnimal.save();
        //List<Animal> animal_list = Animal.all();
        //System.out.println(animal_list);

        assertTrue(Animal.all().get(0).equals(testAnimal));
    }
}
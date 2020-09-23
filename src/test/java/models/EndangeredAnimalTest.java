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
        assertEquals("endangered animal",testAnimal.getType());
    }

//    @Test
//    public void equals_returnTrueWhenObjectsHaveSameValues_true(){
//        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion");
//        EndangeredAnimal testAnimal2 = new EndangeredAnimal("Elephant");
//        assertTrue(testAnimal.equals(testAnimal2));
//
//    }

    @Test
    public void save_addAnimalToDatabase_void(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion");
        testAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testAnimal));
    }
    @Test
    public void all_returnAllAnimals_List(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion");
        testAnimal.save();
        EndangeredAnimal testAnimal2 = new EndangeredAnimal("Elephant");
        testAnimal2.save();
        assertEquals(2,EndangeredAnimal.all().size());
    }
//    @Test
//    public void saveAge_addAgeOfEndangeredAnimalToDB_void(){
//        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion");
//        testAnimal.save();
//        testAnimal.saveAge("young");
//        assertEquals("young",EndangeredAnimal.all().get(0).getAge());
//
//    }
    @Test
    public void saveHealth_addHealthOfEndangeredAnimalToDB_void(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion");
        testAnimal.save();
        testAnimal.setHealth("okay");
        testAnimal.saveHealth(health);
        assertEquals("okay",EndangeredAnimal.all().get(1).getHealth());
    }


}
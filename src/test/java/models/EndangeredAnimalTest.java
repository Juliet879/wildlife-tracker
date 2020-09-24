package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiateCorrectly_true(){
        EndangeredAnimal testAnimal = setUpEndangeredAnimal();
        assertTrue(testAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void animal_instantiateWithName_String(){
        EndangeredAnimal testAnimal = setUpEndangeredAnimal();
        assertEquals("lion", testAnimal.getName());
    }
    @Test
    public void animal_instantiateWithCorrectType_String(){
        EndangeredAnimal testAnimal = setUpEndangeredAnimal();
        assertEquals("endangered animal", testAnimal.getType());
    }
    @Test
    public void equals_returnTrueWhenObjectsHaveSameValues_true(){
        EndangeredAnimal testAnimal = setUpEndangeredAnimal();
        EndangeredAnimal testAnimal2 = setUpEndangeredAnimal();
        assertTrue(testAnimal.equals(testAnimal2));
    }
    @Test
    public void save_addAnimalToDatabase_void(){
        EndangeredAnimal testAnimal = setUpEndangeredAnimal();
        testAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testAnimal));
    }
    @Test
    public void all_returnAllAnimals_List(){
        EndangeredAnimal testAnimal = setUpEndangeredAnimal();
        testAnimal.save();
        EndangeredAnimal testAnimal2 = setUpEndangeredAnimal();
        testAnimal2.save();
        assertEquals(2,EndangeredAnimal.all().size());
    }
    @Test
    public void saveAge_addsAgeOfEndangeredAnimalToDB_void(){
        EndangeredAnimal testAnimal = setUpEndangeredAnimal();
        testAnimal.save();
        testAnimal.saveAge("newborn");
       assertEquals("newborn",EndangeredAnimal.all().get(0).getAge());
    }
//    @Test
//    public void saveHealth_addsHealthOfEndangeredAnimalToDB_void(){
//        EndangeredAnimal testAnimal = setUpEndangeredAnimal();
//        testAnimal.save();
//        testAnimal.saveHealth("okay");
//        assertEquals("okay",EndangeredAnimal.all().get(0).getHealth());
//    }
    @Test
    public void animal_instantiateWithCorrectId_int(){

    }

    //helper class
    public EndangeredAnimal setUpEndangeredAnimal(){
        return new EndangeredAnimal("lion");
    }

}

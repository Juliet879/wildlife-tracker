package models;
import org.junit.Rule;
import org.junit.Test;


public class AnimalTest {
    @Rule
    public  DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiateCorrectly_true(){
        Animal testAnimal = setUpAnimal();
        assertTrue(testAnimal instanceof Animal);
    }
    @Test
    public void animal_instantiateWithName_String(){
        Animal testAnimal = setUpAnimal();
        assertEquals("animal",testAnimal.getName());
    }
    @Test
    public void animal_instantiateWithCorrectType_String(){
        Animal testAnimal = setUpAnimal();
        assertEquals("animal",testAnimal.getType());
    }
    @Test
    public void equals_returnTrueWhenObjectsHaveSameValues_true(){
        Animal testAnimal = setUpAnimal();
        Animal testAnimal2 = setUpAnimal();
        aasertTrue(testAnimal.equals(testAnimal2));
    }
    @Test
    public void save_addAnimalToDatabase_void(){
        Animal testAnimal = setUpAnimal();
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }
    @Test
    public void all_returnAllAnimals_List(){
        Animal testAnimal = setUpAnimal();
        testAnimal.save();
        Animal testAnimal2 = setUpAnimal();
        testAnimal2.save();
        assertEquals(2,Animal.all().size());
    }
    @Test
    public void animal_instantiateWithCorrectId_int(){

    }
    public Animal setUpAnimal(){
        return new Animal("lion");
    }
    }
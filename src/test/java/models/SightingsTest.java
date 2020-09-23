package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sightings_instantiateCorrectly_object(){
        Sightings testSightings = setUpSettings();
        assertTrue(testSightings instanceof Sightings);
    }
    @Test
    public void sightings_instantiateWithCorrectLocation_String(){
        Sightings testSightings = setUpSettings();
        assertEquals("Nyali",testSightings.getLocation());
    }
    @Test
    public void sightings_instantiateWithCorrectRangerName_String(){
        Sightings testSightings = setUpSettings();
        assertEquals("Juliet",testSightings.getRangerName());
    }
    @Test
    public void sightings_instantiateWithCorrectWildlifeId_int(){
        Sightings testSightings = setUpSettings();
        assertEquals(0,testSightings.getWildlifeId());
    }
    @Test
    public void save_addSightingsToDB_void(){
        Sightings testSightings = setUpSettings();
        testSightings.save();
        //assertTrue(Sightings.all().get(0).equals(testSightings));
    }

   public Sightings setUpSettings(){
       return new Sightings("Nyali", "Juliet", 0, "Okay", "Adult");

   }
}
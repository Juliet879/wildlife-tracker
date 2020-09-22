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

   public Sightings setUpSettings(){
        return new Sightings("Nyali","Juliet",1);
   }
}
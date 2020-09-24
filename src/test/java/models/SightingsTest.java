package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void sightings_instantiateCorrectly_object(){
        Sightings testSightings = setUpSettings();
        assertTrue(testSightings instanceof Sightings);
    }

    @Test
    public void sightings_instantiateWithCorrectLocation_String(){
        Sightings testSightings = setUpSettings();
        assertEquals("Mt Kenya",testSightings.getLocation());
    }
    @Test
    public void sightings_instantiateWithCorrectRangerName_string(){
        Sightings testSightings = setUpSettings();
        assertEquals("victor",testSightings.getRangerName());
    }
    @Test
    public void sightings_instantiateWithCorrectWildlifeId_string(){
        Sightings testSightings = setUpSettings();
        assertEquals(1, testSightings.getWildlifeId());
    }
//    @Test
//    public void save_addSightingToTheDB_void(){
//        Sightings testSightings = setUpSettings();
//        testSightings.save();
//        assertTrue(!Sightings.all().get(0).equals(testSightings));
//    }

    @Test
    public void all_returnsAllSightingsFromDB_List(){
        Sightings testSightings = setUpSettings();
        testSightings.save();
        Sightings testSightings2 = setUpSettings();
        testSightings2.save();
        assertEquals(2,Sightings.all().size());
    }

    //helper class
    public Sightings setUpSettings(){
        return new Sightings("Mt Kenya","victor",1);
    }
}

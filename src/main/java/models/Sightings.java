package models;

import java.sql.Timestamp;

public class Sightings {
    private int id;
    private String location;
    private String ranger_name;
    private int wildlife_id ;
    private Timestamp time;


    public Sightings(String location,String ranger_name,int wildlife_id){
        this.location = location;
        this.ranger_name = ranger_name;
        this.wildlife_id = wildlife_id;
    }
}

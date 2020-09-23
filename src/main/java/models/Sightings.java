package models;
import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

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

    public static List<Sightings> all() {
        return null;
    }


    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public int getWildlifeId() {
        return wildlife_id;
    }

    public String getRangerName() {
        return ranger_name;
    }
    public void save(){
       try(Connection con = DB.sql2o.open()){
           String sql = "INSERT INTO sightings(location,ranger_name,wildlife_id,time) VALUES (:location, :ranger_name, :wildlife_id, now()";
           this.id = (int)con.createQuery(sql,true)
                   .addParameter("location",this.location)
                   .addParameter("ranger_name",this.ranger_name)
                   .addParameter("wildlife_id", this.wildlife_id)
                   .executeUpdate()
                   .getKey();
       }
       }

    }


package models;
import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

public class Sightings {
    private int id;
    private String location;
    private String rangername;
    private int wildlifeid ;
//    private Timestamp lastseen;
    private String health;
    private String age;


    public Sightings(String location,String rangername,int wildlifeid, String health, String age){
        this.location = location;
        this.rangername = rangername;
        this.wildlifeid = wildlifeid;
//        this.lastseen = lastseen;
        this.health = health;
        this.age = age;
    }

    public static List<Object> all() {
        return null;
    }


    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public int getWildlifeId() {
        return wildlifeid;
    }

    public String getRangerName() {
        return rangername;
    }

//    public Timestamp getLastseen() {
//        return lastseen;
//    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public void save(){
       try(Connection con = DB.sql2o.open()){
           String sql = "INSERT INTO sightings(location,rangername,wildlifeid) VALUES (:location, :rangername, :wildlifeid)";
           this.id = (int) con.createQuery(sql,true)
                   .addParameter("location",this.location)
                   .addParameter("rangername",this.rangername)
                   .addParameter("wildlifeid", this.wildlifeid)
                   //.addParameter("health", this.health)
                   //.addParameter("age", this.age)
                   .executeUpdate()
                   .getKey();
       }
       }

    }


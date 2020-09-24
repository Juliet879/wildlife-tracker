package models;

import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Sightings {
    private int id;
    private String location;
    private String ranger_name;
    private int wildlife_id;
    private Timestamp time;

    public Sightings(String location, String ranger_name, int wildlife_id) {
        this.location = location;
        this.ranger_name = ranger_name;
        this.wildlife_id = wildlife_id;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return ranger_name;
    }

    public int getWildlifeId() {
        return wildlife_id;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO sightings(location, ranger_name, wildlife_id, time) VALUES(:location, :ranger_name,:wildlife_id, now())";
            this.id =(int) con.createQuery(sql,true)
                    .addParameter("location",this.location)
                    .addParameter("ranger_name",this.ranger_name)
                    .addParameter("wildlife_id", this.wildlife_id)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sightings> all(){
        String querySightings = "SELECT * FROM sightings";
        try (Connection con =DB.sql2o.open()){
            return con.createQuery(querySightings)
                    .executeAndFetch(Sightings.class);
        }
    }

    public Timestamp getTime() { return time; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings) o;
        return wildlife_id == sightings.wildlife_id &&
                Objects.equals(location, sightings.location) &&
                Objects.equals(ranger_name, sightings.ranger_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, ranger_name, wildlife_id);
    }
}

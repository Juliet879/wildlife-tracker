package models;

import models.DB;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() throws Throwable {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker","moringa", "julietgisemba123");
    }

    @Override
    protected void after() {
        try (Connection con = DB.sql2o.open()){
            String deleteAnimals = "DELETE FROM animals *;";
            String deleteSightings = "DELETE FROM sightings *;";
            con.createQuery(deleteAnimals).executeUpdate();
            con.createQuery(deleteSightings).executeUpdate();
        }
    }
}

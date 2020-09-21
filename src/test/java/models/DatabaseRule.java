package models;

import models.DB;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() throws Throwable{
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/virtual_pets_test", "moringa", "julietgisemba123");  //Those with linux or windows use two strings for username and password
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deletePersonsQuery = "DELETE FROM animals *;";
            String deleteMonstersQuery = "DELETE FROM sightings *;";
            con.createQuery(deletePersonsQuery).executeUpdate();
            con.createQuery(deleteMonstersQuery).executeUpdate();
        }
    }


}

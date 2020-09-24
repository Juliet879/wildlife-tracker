package models;

import org.sql2o.Connection;

import java.util.List;

public class Animal extends Wildlife {

    public static final String DATABASE_TYPE = "animal";

    public Animal(String name) {
        this.name = name;
        this.type = DATABASE_TYPE;
    }
    public static List<Animal> all(){
        try (Connection con = DB.sql2o.open()){
            String queryAnimals ="SELECT * FROM animals WHERE type='animal'";
            return con.createQuery(queryAnimals)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);

        }
    }

}
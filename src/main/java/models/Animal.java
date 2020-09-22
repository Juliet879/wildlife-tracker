package models;

import org.sql2o.Connection;

import java.util.List;


public class Animal extends Wildlife {
    public int id;
    public static final String DATABASE_TYPE = "animal";

    public Animal(String name){
         this.name = name;
         this.type = DATABASE_TYPE;
    }

    public static List<Animal> all(){
        try(Connection con = DB.sql2o.open()){
           String queryAnimals = "SELECT * FROM animals WHERE type='animal'";
           return con.createQuery(queryAnimals)
                   .executeAndFetch(Animal.class);
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id;
    }

    @Override
    public int hashCode() {
        return 0;
    }


}
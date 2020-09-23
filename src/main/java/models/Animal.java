package models;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;


public class Animal extends Wildlife {
    public int id;
    public static final String DATABASE_TYPE = "animal";
    public String age;
    public String time;
    public String health;

    public Animal(String name){
         this.name = name;
         this.age = "";
         this.health = "";
         this.type = DATABASE_TYPE;
         this.time = "";
    }

    public static List<Animal> all(){
        try(Connection con = DB.sql2o.open()){
           String queryAnimals = "SELECT * FROM animals WHERE type='animal'";
           return con.createQuery(queryAnimals)
                   .executeAndFetch(Animal.class);
        }
    }





}
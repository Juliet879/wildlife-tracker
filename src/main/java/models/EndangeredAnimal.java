package models;

import org.sql2o.Connection;
import java.util.List;

public class EndangeredAnimal extends Wildlife{
    public static final String HEALTHY = "healthy";
    public static final String OKAY = "okay";
    public static final String ILL = "ill";
    public static final String NEWBORN = "newborn";
    public static final String YOUNG = "young";
    public static final String ADULT = "adult";
    public static final String DATABASE_TYPE = "endangered animal";

    private String age;
    private String health;

    public EndangeredAnimal(String name) {
        this.name = name;
        this.type = DATABASE_TYPE;
    }

  //
    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health){
        this.health = health;
    }


        public static List<EndangeredAnimal> all(){
            try(Connection con = DB.sql2o.open()){
                String queryAnimals = "SELECT * FROM animals WHERE type='endangered animal'";
                return con.createQuery(queryAnimals)
                        .executeAndFetch(EndangeredAnimal.class);
            }
        }



//    public void updateAge(String age){
//        String sql = "UPDATE animals SET age=:age WHERE id=:id";
//        try (Connection con = DB.sql2o.open()){
//            con.createQuery(sql)
//                    .addParameter("age", age)
//                    .addParameter("id", this.id)
//                    .executeUpdate();
//        }
//    }
//

    public void saveHealth(String health){
        String sql = "UPDATE animals SET health = :health WHERE id=:id;";
        try (Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("health", this.health)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

//    public void updateHealth(String health) {
//        try(Connection con = DB.sql2o.open()) {
//            String sql = "UPDATE animals SET health=:health WHERE id=:id;";
//            con.createQuery(sql)
//                    .addParameter("health", health)
//                    .addParameter("id", this.id)
//                    .executeUpdate();
//        }
//    }

    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE id=:id;";
            EndangeredAnimal Endangered = con.createQuery(sql)
                    .addParameter("id", 1)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return Endangered;
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type) VALUES (:name, :type);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
            this.setId(id);
        }
    }

    public void saveAge(String age) {
    }
}
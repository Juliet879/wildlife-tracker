package models;

import org.sql2o.Connection;
import java.util.List;
import java.util.Objects;

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
//    public String getAge() {
//        return age;
//    }
//
//    public String getHealth() {
//        return health;
//    }
//    public static List<EndangeredAnimal> all(){
//            try (Connection con = DB.sql2o.open()){
//                String queryEndangered = "SELECT * FROM animals WHERE type='endangered animal'";
//                return con.createQuery(queryEndangered)
//                        .executeAndFetch(EndangeredAnimal.class);
//            }
//    }
//    public void saveAge(String age){
//        String sql = "UPDATE animal SET age=:age WHERE id=:id";
//        try (Connection con = DB.sql2o.open()){
//            con.createQuery(sql)
//                    .addParameter("age", age)
//                    .addParameter("id", this.id)
//                    .executeUpdate();
//        }
//    }
//    public void saveHealth(String health){
//        String sql = "UPDATE animal SET health=:health WHERE id=:id";
//        try (Connection con = DB.sql2o.open()){
//            con.createQuery(sql)
//                    .addParameter("health",health)
//                    .addParameter("id", this.id)
//                    .executeUpdate();
//        }
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        EndangeredAnimal that = (EndangeredAnimal) o;
//        return Objects.equals(age, that.age) &&
//                Objects.equals(health, that.health);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(age, health);
//    }
}
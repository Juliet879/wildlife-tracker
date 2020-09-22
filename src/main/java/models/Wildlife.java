package models;

import org.sql2o.Connection;

import java.util.Objects;

public abstract class Wildlife implements DatabaseManagement {
    public String name;
    public String type;
    public int id;

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }
    }
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wildlife wildlife = (Wildlife) o;
        return Objects.equals(name, wildlife.name) &&
                Objects.equals(type, wildlife.type);
    }


}

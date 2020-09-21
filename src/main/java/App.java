
import models.Animal;
import models.EndangeredAnimal;
import models.Sightings;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App{
    public static void main(String[] args) {

        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/wildlife/new",(request,response) ->{
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"wildlife.hbs");
        }, new HandlebarsTemplateEngine());

        post("/wildlife/new",(request,response) ->{
            Map<String,Object> model = new HashMap<>();
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String location = request.queryParams("location");
            String name = request.queryParams("name");
            String ranger = request.queryParams("ranger");
            String age = request.queryParams("age");
            String health = request.queryParams("health");

            if(age == null && health == null){
                animal.save();
            }
            else {
                EndangeredAnimal endangeredAnimal = new EndangeredAnimal(name);
                endangeredAnimal.save();
                endangeredAnimal.saveAge(age);
                endangeredAnimal.saveHealth(health);
            }
            Sightings sightings = new Sightings(location,ranger,animalId);
            sightings.save();
            response.redirect("/all-animals");
            return null;
        }, new HandlebarsTemplateEngine());
    }

    private static void staticFileLocation(String s) {
    }
}
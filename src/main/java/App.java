import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

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
            return new ModelAndView(model,"wildlife.hbs")
        })

    }

    private static void staticFileLocation(String s) {
    }
}
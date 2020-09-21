import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.get;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        get("/", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "layout.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

package is.ru.tictactoe;

import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.HashMap;

public class MainWeb {
    private static String layout = "templates/layout.vtl";
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (req, res) -> {
            HashMap model = new HashMap();
            model.put("template", "templates/main.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}

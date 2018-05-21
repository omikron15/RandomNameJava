import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

public class Controller {

        public static void main(String[] args) {
            VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
            staticFileLocation("/public");

            RandomName randomName = new RandomName();


            get("/names", (req, res) -> {

                HashMap<String, Object> model = new HashMap<>();
                model.put("names", randomName.getNames());
                model.put("template", "view.vtl");
                return new ModelAndView(model, "layout.vtl");
            }, velocityTemplateEngine);

            get("/names/one", (req, res) -> {

                HashMap<String, Object> model = new HashMap<>();
                model.put("name", randomName.oneRandomName());
                model.put("template", "one.vtl");
                return new ModelAndView(model, "layout.vtl");
            }, velocityTemplateEngine);

            get("/names/two", (req, res) -> {

                HashMap<String, Object> model = new HashMap<>();
                model.put("names", randomName.twoRandomNames());
                model.put("template", "two.vtl");
                return new ModelAndView(model, "layout.vtl");
            }, velocityTemplateEngine);

            get("/names/new", (req, res) -> {
                HashMap<String, Object> model = new HashMap<>();
                model.put("template", "create.vtl");
                return  new ModelAndView(model, "layout.vtl");
            }, velocityTemplateEngine);

            post("/names/new", (req, res) -> {

                String newName = req.queryParams("newName");

                randomName.addName(newName);

                res.redirect("/names");
                return "";
            });



        }



}

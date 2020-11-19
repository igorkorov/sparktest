import spark.ModelAndView;
import spark.Request;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static spark.Spark.*;

public class Spark {
    public static Map map_ = new HashMap<>();
    public static VelocityTemplateEngine eng =  new VelocityTemplateEngine();
    public static ModelAndView OK = new ModelAndView(map_, "OK.html");
    public static ModelAndView BAD = new ModelAndView(map_, "Bad.html");

    public static void main(String[] args) {
        redirect.get("/", "template-example");
        get("/hello", (req, res) -> "Hello World");
        get("template-example", (req, res) -> {
            boolean authenticated=true;
            // ... check if authenticated
            if (!authenticated) {
                halt(401, "You are not welcome here");
            }

            return eng.render(
                    new ModelAndView(map_, "login.html")
            );
        });
        get("/check", (req, res) ->{
            if (check(req))
                return eng.render(OK);
            return eng.render(BAD);
        });
        get("/login", (req, res) -> {
            System.out.println("QUery::=>");
            req.queryParams().forEach(a->{System.out.println(a);});
            System.out.println("LOGIN::"+req.queryParams("login"));
            System.out.println("PASS::"+req.queryParams("password"));


            Map a = req.params();
            System.out.println("login request");
            Iterator<Map.Entry<String, String>> it = a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> pair = it.next();
                System.out.println(pair.getKey()+ "...."+ pair.getValue());
            }
            return eng.render(OK);
        });

        get("/hack", (req, res) ->{
           req.session().attribute("logined", true);
           return eng.render(      new ModelAndView(map_, "success.html")
        );});
        get("/attr", (req,res)->{
            Set<String> attr = req.session().attributes();
            attr.forEach(a -> {System.out.println(a);});
            if (attr.isEmpty())
                req.session().attribute("logined", false);
            return eng.render(OK);
        });


    }
    public static boolean check(Request req){
        Set<String> attr = req.session().attributes();
        attr.forEach(a -> {System.out.println(a);});
        if (attr.isEmpty())
            req.session().attribute("logined", false);
        if (req.session().attribute("logined").equals(true)) return true;
        return false;
    }
}

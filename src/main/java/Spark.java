import org.jetbrains.annotations.NotNull;
import spark.ModelAndView;
import spark.Request;
import spark.template.velocity.VelocityTemplateEngine;
import util.Deps;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static spark.Spark.*;
public class Spark {
    public static Map map_ = new HashMap<>();
    public static VelocityTemplateEngine eng =  new VelocityTemplateEngine();
    public static ModelAndView OK = new ModelAndView(map_, "OK.html");
    public static ModelAndView BAD = new ModelAndView(map_, "Bad.html");
    public static ModelAndView SOCKET = new ModelAndView(map_, "websocket.html");
    public static Map<String, Object> model = new HashMap<>();
    public static void main(String[] args) throws InterruptedException {
        Deps deps = new Deps();
        webSocket("/echo", EchoWebSocket.class);

        get("websocket", (req, res) -> eng.render(SOCKET));

        redirect.get("/", "login.area");
        get("/hello", (req, res) -> "Hello World");
        get("login.area", (req, res) -> {
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
            String login = req.queryParams("login");
            String pass = req.queryParams("password");
            if (deps.loginchecker.checklogin(login, pass)) {
                req.session().attribute("logined", true);
                req.session().attribute("user", login);
                model.clear();
                model.put("user", login);
                model.put("id", req.session().id());
                return new VelocityTemplateEngine().render(
                        new ModelAndView(model, "welcome.html")
                );
            }
            else
                req.session().attribute("logined", false);
                return eng.render(BAD);
        });

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

    public static void flushsession(@NotNull Request req){
        req.session().attribute("logined", false);
    }

}

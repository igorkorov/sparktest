package servers;

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import util.Deps;
import util.JSON.LoaderJSON;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.*;


@WebSocket(maxIdleTime=50000000)
public class EchoWebSocket {
    // Store sessions if you want to, for example, broadcast a message to all users
    private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();
    public static Deps deps;

    public static void sendall(String id)  {
        ArrayList param = new ArrayList();
        param.add(id);
        sessions.forEach(a-> {
            try {
                a.getRemote().sendString(deps.LoaderJSON.LoadResult2JSON(id));
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @OnWebSocketConnect
    public void connected(Session session) {
     //   System.out.println("Connceted: " );   // Print message
        sessions.add(session);
    }

    @OnWebSocketClose
    public void closed(Session session, int statusCode, String reason) {
        sessions.remove(session);
    }

    @OnWebSocketMessage
    public void message(Session session, String message) throws IOException {
        System.out.println("Got: " + message);   // Print message
        session.getRemote().sendString(message); // and send it back

    }

    public static  void sendall(){
        sessions.forEach(a-> {
            try {

                a.getRemote().sendString("Получен новый запрос! проверьте таблицу");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
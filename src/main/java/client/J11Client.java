package client;
import essent.Client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class J11Client extends Client {
    public HttpClient client = HttpClient.newHttpClient();

    @Override
    public int send(byte[] serializedMessage, String whom) throws IOException {
        HttpRequest mainRequest = HttpRequest.newBuilder()
                .uri(URI.create(whom))
                .POST(HttpRequest.BodyPublishers.ofByteArray(serializedMessage))
                .build();
        client.sendAsync(mainRequest, HttpResponse.BodyHandlers.ofByteArray())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
        return 0;

        /*


        tring url = whom;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
;

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(serializedMessage);


        FileOutputStream fos = new FileOutputStream("SENDED");
        fos.write(serializedMessage.getBytes());
        fos.close();


        wr.flush();
        wr.close();
        System.out.println("RESPONCED CODE>>"+con.getResponseCode());
return con.getResponseCode();

         */




    }
}

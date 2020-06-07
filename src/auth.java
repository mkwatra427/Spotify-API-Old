/**
 * Created by Mitran Kwatra on 6/1/2018.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.web.client.RestTemplate;
//import org.springframework.core.NestedRuntimeException;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.PrimitiveIterator;
import java.util.Random;
import javax.json.*;

import javafx.scene.Node;
import javafx.scene.web.*;

public class auth extends Application {

    /* to get an auth token string from a token object,
       use getAuthToken().getJsonString("access_token").getString()
     */

    private static int stateKeyLength = 10;
    private static String myClientID = "23178f35c11f46b6b8707ab68232b3cc";
    private static String myb64key = "MjMxNzhmMzVjMTFmNDZiNmI4NzA3YWI2ODIzMmIzY2M6NzU5YmFhOGUxNGI3NGJhZDg0MmE2YTZmOTU2NDFjOWQ="; // HARDCODED
    private static String callback = "https://listentome427.wordpress.com/callback";

    public static JsonObject getCCAuthToken() throws IOException {

        URL url = new URL("https://accounts.spotify.com/api/token");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Basic " + myb64key);
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        out.write("grant_type=client_credentials");
        out.close();

        return Json.createReader(connection.getInputStream()).readObject();

    }

    public static CCAuthToken alt() {

        return null; //new RestTemplate().getForObject("https://accounts.apotify.com/api/token?grant_type=client_credentials", CCAuthToken.class);

    }

    public static void getACAuthToken() throws IOException, URISyntaxException {

        URI uri = new URI("https://accounts.spotify.com/authorize/?client_id=" + myClientID +
                "&response_type=code&redirect_uri=" + callback + "&state=" +
                genRndmString(stateKeyLength));
        Desktop.getDesktop().browse(uri);

        /*URLConnection outConnection = url.openConnection();
        outConnection.setDoOutput(true);
        OutputStreamWriter out = new OutputStreamWriter(outConnection.getOutputStream());
        out.close();*/

    }

    public static String getAcUri() {

        return "https://accounts.spotify.com/authorize/?client_id=" + myClientID +
                "&response_type=code&redirect_uri=" + callback + "&state=" +
                genRndmString(stateKeyLength);

    }

    public static String genRndmString(int length) {

        StringBuilder builder = new StringBuilder();
        PrimitiveIterator.OfInt stream = new Random().ints(length, 65, 90).iterator();
        while(stream.hasNext())
            builder.append((char)stream.nextInt());

        return builder.toString();

    }

    @Override
    public void start(Stage stage) throws Exception {

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.setUserAgent("use required / intended UA string");
        webEngine.load(getAcUri());

        stage.setScene(new Scene(webView));
        stage.show();
        System.out.println(webEngine.getLocation());

    }

    public static void main(String[] args) throws IOException, URISyntaxException {

        Application.launch(args);

    }

}

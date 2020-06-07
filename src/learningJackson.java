/**
 * Created by Mitran Kwatra on 7/8/2018.
 */

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;

import org.springframework.web.client.RestTemplate;


import java.io.OutputStreamWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class learningJackson {

    private static String myb64key = "MjMxNzhmMzVjMTFmNDZiNmI4NzA3YWI2ODIzMmIzY2M6NzU5YmFhOGUxNGI3NGJhZDg0MmE2YTZmOTU2NDFjOWQ=";

    public static CCAuthToken getToken() throws IOException {

        // from auth.getCCAuthToken
        URL url = new URL("https://accounts.spotify.com/api/token");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Basic " + myb64key);
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        out.write("grant_type=client_credentials");
        out.close();

        ObjectMapper om = new ObjectMapper();
        return om.readValue(connection.getInputStream(), CCAuthToken.class);
        /*
        return new RestTemplate().getForObject("https://accounts.apotify.com/api/token?grant_type=client_credentials", CCAuthToken.class);
         */

    }

    public static void main(String[] args) throws IOException {

        System.out.println(getToken().toString());

    }

}

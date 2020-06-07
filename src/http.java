/**
 * Created by Mitran Kwatra on 6/1/2018.
 */

import beans.Playlist;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.*;
import java.io.*;

public class http {

    private CCAuthToken currentToken;

    public http() throws IOException {
        currentToken = learningJackson.getToken(); // or wherever you want to get a token from
    }

    public Playlist[] getPlaylists(String user) throws IOException {

        URLConnection connection = new URL("https://api.spotify.com/v1/users/" + user + "/playlists").openConnection();
        connection.setRequestProperty("Authorizarion", "Bearer " + auth.getCCAuthToken().getJsonString("access_token").getString());
        ObjectMapper om = new ObjectMapper();
        return om.readValue(connection.getInputStream(), Playlist[].class);

    }

    public static void main(String[] args) throws IOException {

        URL me = new URL("https://api.spotify.com/v1/users/mkwatra427/playlists/58DVwlE6Ht2wlgsJHs8QJg");
        URLConnection self = me.openConnection();
        self.setRequestProperty("Authorization", "Bearer " + auth.getCCAuthToken().getJsonString("access_token").getString());
        BufferedReader in = new BufferedReader(new InputStreamReader(self.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();

    }

    public static void main1(String[] args) throws IOException {
        System.out.println(new http().getPlaylists("mkwatra427"));
    }

}

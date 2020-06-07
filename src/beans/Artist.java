package beans;

import java.util.ArrayList;

/**
 * Created by Mitran Kwatra on 7/30/2018.
 */
public class Artist {

    private String name;
    private ArrayList<Album> albums;

    public Artist(String name, ArrayList<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<Album>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album newAlbum) {
        albums.add(newAlbum);
    }

}

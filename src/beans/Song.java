package beans;

/**
 * Created by Mitran Kwatra on 7/30/2018.
 */
public class Song {

    private String name;
    private Artist artist;
    private Album album;

    public Song(String name, Artist artist, Album album) {
        this.name = name;
        this.artist = artist;
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }
}

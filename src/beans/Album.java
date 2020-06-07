package beans;

/**
 * Created by Mitran Kwatra on 7/30/2018.
 */
public class Album {

    private String name;
    private Artist artist;
    private Song[] songs;
    private int releaseYear;

    public Album(String name, Artist artist, Song[] songs, int releaseYear) {
        this.name = name;
        this.artist = artist;
        this.songs = songs;
        this.releaseYear = releaseYear;
    }

    public Album(String name, Artist artist, Song[] songs) {
        this.name = name;
        this.artist = artist;
        this.songs = songs;
    }

    public Album(String name, Artist artist, int releaseYear) {
        this.name = name;
        this.artist = artist;
        this.releaseYear = releaseYear;
    }

    public Album(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}

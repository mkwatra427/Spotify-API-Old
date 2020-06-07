package beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedList;

/**
 * Created by Mitran Kwatra on 7/30/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Playlist {

    private String name;
    private LinkedList<Song> songs;
    private User creator;

    public Playlist(String name, User creator) {
        this.name = name;
        this.creator = creator;
        this.songs = new LinkedList<Song>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }

    public void addSong(Song newSong) {
        songs.add(newSong);
    }

    public void deleteSong(Song song) {
        songs.remove(song);
    }

    public User getCreator() {
        return creator;
    }
}

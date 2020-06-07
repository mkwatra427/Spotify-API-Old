package beans;

import java.util.LinkedList;

/**
 * Created by Mitran Kwatra on 7/30/2018.
 */
public class User {

    private String UID;
    private String displayName;
    private LinkedList<Playlist> playlists;

    public User(String UID, String displayName) {
        this.UID = UID;
        this.displayName = displayName;
        this.playlists = new LinkedList<Playlist>();
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public LinkedList<Playlist> getPlaylists() {
        return playlists;
    }

    public Playlist getPlaylist(String name) {
        for(Playlist playlist : playlists) {
            if(playlist.getName().equals(name))
                return playlist;
        }
        return null;
    }

    public Playlist newPlaylist(String name) {
        Playlist newPlaylist = new Playlist(name, this);
        playlists.add(newPlaylist);
        return newPlaylist;
    }

    public void deletePlaylist(Playlist playlist) {
        playlists.remove(playlist);
    }

}

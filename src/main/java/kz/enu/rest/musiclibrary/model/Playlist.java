package kz.enu.rest.musiclibrary.model;

public class Playlist {
    private String name;
    private String[] songs;

    public Playlist() {}

    public Playlist(String name, String[] songs) {
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSongs() {
        return songs;
    }

    public void setSongs(String[] songs) {
        this.songs = songs;
    }
}

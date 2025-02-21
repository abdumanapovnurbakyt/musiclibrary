package kz.enu.rest.musiclibrary.controller;

import kz.enu.rest.musiclibrary.model.Artist;
import kz.enu.rest.musiclibrary.model.Song;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongController {
    private final Song[] songs = new Song[100];
    private int i = 0;
    private final ArtistController artistController;

    public SongController(ArtistController artistController) {
        this.artistController = artistController;
    }

    @PostMapping
    public String addSong(@RequestBody Song song) {
        boolean artistExists = false;
        for (Artist artist : artistController.getArtists()) {
            if (artist != null && artist.getName().equals(song.getArtist())) {
                artistExists = true;
                break;
            }
        }

        if (!artistExists) {
            return "Исполнитель " + song.getArtist() + " не найден!";
        }

        if (i >= songs.length) {
            return "Error";
        }
        songs[i++] = song;
        return "Песня добавлена: " + song.getTitle();
    }

    @GetMapping
    public Song[] getAllSongs() {
        return songs;
    }

    public Song[] getSongs() {
        return songs;
    }
}

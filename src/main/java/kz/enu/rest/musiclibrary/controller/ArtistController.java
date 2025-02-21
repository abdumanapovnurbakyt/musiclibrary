package kz.enu.rest.musiclibrary.controller;

import kz.enu.rest.musiclibrary.model.Artist;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private final Artist[] artists = new Artist[10];
    private int i = 0;

    @PostMapping
    public String addArtist(@RequestBody Artist artist) {
        if (i >= artists.length) {
            return "Error";
        }
        artists[i++] = artist;
        return "Исполнитель добавлен: " + artist.getName();
    }

    @GetMapping
    public Artist[] getAllArtists() {
        return artists;
    }

    public Artist[] getArtists() {
        return artists;
    }
}

package kz.enu.rest.musiclibrary.controller;

import kz.enu.rest.musiclibrary.model.Playlist;
import kz.enu.rest.musiclibrary.model.Song;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    private final Playlist[] playlists = new Playlist[10];
    private int i = 0;
    private final SongController songController;

    public PlaylistController(SongController songController) {
        this.songController = songController;
    }

    @PostMapping
    public String addPlaylist(@RequestBody Playlist playlist) {
        for (String songTitle : playlist.getSongs()) {
            boolean songExists = false;
            for (Song existingSong : songController.getSongs()) {
                if (existingSong != null && existingSong.getTitle().equals(songTitle)) {
                    songExists = true;
                    break;
                }
            }
            if (!songExists) {
                return "Ошибка: Песня " + songTitle + " не найдена!";
            }
        }

        if (i >= playlists.length) {
            return "Error";
        }
        playlists[i++] = playlist;
        return "Плейлист добавлен: " + playlist.getName();
    }

    @GetMapping
    public Playlist[] getAllPlaylists() {
        return playlists;
    }
}

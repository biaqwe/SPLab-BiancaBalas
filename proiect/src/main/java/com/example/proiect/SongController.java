package com.example.proiect;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private List<Song> playlist = new ArrayList<>();

    public SongController() {
        playlist.add(new Song("1", "Synth Wave", "SoundHelix", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"));
        playlist.add(new Song("2", "Electronic Vibes", "SoundHelix", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-15.mp3"));
    }

    @GetMapping
    public List<Song> getSongs() {
        return playlist;
    }

    @PostMapping
    public Song addSong(@RequestBody Song song) {
        song.setId(UUID.randomUUID().toString());
        playlist.add(song);
        return song;
    }
}
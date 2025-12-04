package com.example.proiect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongRepository repository;

    @Autowired
    public SongController(SongRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Song> getSongs() {
        return repository.findAll();
    }

    @PostMapping
    public Song addSong(@RequestBody Song song) {
        return repository.save(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable String id) {
        repository.deleteById(id);
    }
}
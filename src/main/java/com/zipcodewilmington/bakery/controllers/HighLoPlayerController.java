package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.HighLoPlayer;
import com.zipcodewilmington.bakery.services.HighLoPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HighLoPlayerController {

    private HighLoPlayerService highLoPlayerService;

    @Autowired
    public HighLoPlayerController(HighLoPlayerService highLoPlayerService) {
        this.highLoPlayerService = highLoPlayerService;
    }
    @PostMapping (name = "/hiloplayers")
    public ResponseEntity<HighLoPlayer> create(@RequestBody HighLoPlayer highLoPlayer) {
        return new ResponseEntity<>(highLoPlayerService.create(highLoPlayer), HttpStatus.CREATED);
    }
    @GetMapping(name = "/hiloplayers/{id}")
    public ResponseEntity<HighLoPlayer>  show(@PathVariable Long accountId) {
        return new ResponseEntity<>(highLoPlayerService.show(accountId), HttpStatus.OK);
    }

    @PutMapping(name = "/hiloplayers/{id}")
    public ResponseEntity<HighLoPlayer>  update(@PathVariable Long gameId, @RequestBody HighLoPlayer highLoPlayer) {
        return new ResponseEntity<>(highLoPlayerService.update(gameId, highLoPlayer), HttpStatus.OK);
    }

    @DeleteMapping(name = "/hiloplayers/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long gameId) {
        return new ResponseEntity<>(highLoPlayerService.delete(gameId), HttpStatus.OK);
    }
}

package com.techiteasycontroller.techiteasycontroller.controllers;

import exeptions.NameNotApprovedException;
import exeptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TelevisionController {

    private ArrayList<String> tvlist = new ArrayList<>();


    @PostMapping("/addtv")
    public ResponseEntity<Object> addTV(@RequestBody String tv) {
        if (tv.length() > 20) {
            throw new NameNotApprovedException("tvnaam is groter dan 20 karakter");
        } else if (tv.length() < 4){
            throw new NameNotApprovedException("tv naam is kleiner dan 4 karakters");
        } else {
            this.tvlist.add(tv);
            return ResponseEntity.created(null).body(tv + " tv is toegevoegd");
        }


    }

    @GetMapping("/showtv")
    public ResponseEntity<Object> showTvList() {
        return ResponseEntity.ok("Dit is een lijst met tv's");
    }

    @GetMapping("/showtv/{id}")
    public ResponseEntity<Object> showTv(@PathVariable ("id") int id) {
        if (id < 10) {
            return ResponseEntity.ok(id + " Dit is een tv");
        } else {
            throw new RecordNotFoundException("Getal is hoger dan 10");
        }

    }

    @PutMapping("/changetvlist/{id}")
    public ResponseEntity<Object> changetvlist(@PathVariable ("id") String id, @RequestBody String name) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletetv/{id}")
    public ResponseEntity<Object> deleteTv(@PathVariable ("id") int id) {
        return ResponseEntity.noContent().build();
    }


}
package com.sid.gallery;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class GalleryController {

    private Map<String, Photos> db = new HashMap<>(){{ put("1", new Photos("1", "hello.jpg"));
    }};
    @GetMapping("/")
    public String hello() {
        return "Hello Sid";
    }

    @GetMapping("/photos")
    public Collection<Photos> get() {
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public Photos get(@PathVariable String id) {
        Photos photos = db.get(id);
        if (photos == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photos;
    }

    @DeleteMapping("/photos/{id}")
    public void del(@PathVariable String id) {
        Photos photos = db.remove(id);
        if (photos == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photos")
    public Photos create(@RequestBody Photos photos){
        photos.setId(UUID.randomUUID().toString());
        db.put(photos.getId(), photos);
        return photos;
    }
}

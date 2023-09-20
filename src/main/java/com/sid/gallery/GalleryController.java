package com.sid.gallery;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
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
    public Photos create(@RequestPart("data") MultipartFile file) throws IOException {
        Photos photos = new Photos();
        photos.setId(UUID.randomUUID().toString());
        photos.setFilename(file.getOriginalFilename());
        photos.setData(file.getBytes());
        db.put(photos.getId(), photos);
        return photos;
    }
}

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

//    private Map<String, Photos> db = new HashMap<>(){{ put("1", new Photos("1", "hello.jpg"));
//    }};

    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService){
        this.galleryService = galleryService;
    }


    @GetMapping("/")
    public String hello() {
        return "Hello Sid";
    }

    @GetMapping("/photos")
    public Collection<Photos> get() {
        return galleryService.get();
    }

    @GetMapping("/photos/{id}")
    public Photos get(@PathVariable String id) {
        Photos photos = galleryService.get(id);
        if (photos == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photos;
    }

    @DeleteMapping("/photos/{id}")
    public void del(@PathVariable String id) {
        Photos photos = galleryService.remove(id);
        if (photos == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photos")
    public Photos create(@RequestPart("data") MultipartFile file) throws IOException {
        return galleryService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}

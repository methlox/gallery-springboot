package com.sid.gallery;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}

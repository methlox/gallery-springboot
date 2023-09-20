package com.sid.gallery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class GalleryController {

    private List<Photos> db = List.of(new Photos("1", "hello.jpg"));
    @GetMapping("/")
    public String hello() {
        return "Hello Sid";
    }

    @GetMapping("/photos")
    public List<Photos> get() {
        return db;
    }
}

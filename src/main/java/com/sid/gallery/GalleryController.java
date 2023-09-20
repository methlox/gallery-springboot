package com.sid.gallery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GalleryController {
    @GetMapping
    public String hello() {
        return "Hello Sid";
    }
}

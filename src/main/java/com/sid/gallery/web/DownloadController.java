package com.sid.gallery.web;

import com.sid.gallery.service.GalleryService;
import com.sid.gallery.model.Photos;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {

    private final GalleryService galleryService;

    public DownloadController(GalleryService galleryService){
        this.galleryService = galleryService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id){

        Photos photos = galleryService.get(id);
        if (photos == null ) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data = photos.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photos.getContentType()));

        // whether the browser will display or download the photo
        ContentDisposition build = ContentDisposition.builder("attachment")
                .filename(photos.getFilename()).build();
        headers.setContentDisposition(build);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}

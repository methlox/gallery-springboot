package com.sid.gallery.service;

import com.sid.gallery.model.Photos;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GalleryService {
    private Map<String, Photos> db = new HashMap<>(){{ put("1", new Photos("1", "hello.jpg"));
    }};

    public Collection<Photos> get() {
        return db.values();
    }

    public Photos get(String id) {
        return db.get(id);
    }

    public Photos remove(String id) {
        return db.remove(id);
    }

    public Photos save(String filename, String contentType, byte[] data) {
        Photos photos = new Photos();
        photos.setContentType(contentType);
        photos.setId(UUID.randomUUID().toString());
        photos.setFilename(filename);
        photos.setData(data);
        db.put(photos.getId(), photos);
        return photos;
    }
}

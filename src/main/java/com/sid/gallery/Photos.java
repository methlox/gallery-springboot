package com.sid.gallery;

import jakarta.validation.constraints.NotEmpty;

public class Photos {

    private String id;

    @NotEmpty
    private String filename;

    public Photos() {
    }

    public Photos(String id, String filename) {
        this.id = id;
        this.filename = filename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}

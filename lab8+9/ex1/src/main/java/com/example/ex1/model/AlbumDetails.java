package com.example.ex1.model;

import javax.persistence.*;

@Entity
@Table(name = "album_details")
public class AlbumDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumDetailsId;
//    @Column(name = "description")
    private String description;

    public AlbumDetails() {
    }

    public AlbumDetails(String description) {
        this.description = description;
    }

    public int getAlbumDetailsId() {
        return albumDetailsId;
    }

    public void setAlbumDetailsId(int albumDetailsId) {
        this.albumDetailsId = albumDetailsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

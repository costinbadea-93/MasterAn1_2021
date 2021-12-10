package com.example.ex1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumId;
    private String albumName;
    private int albumQuantity;

    @OneToOne
    @JoinColumn(name = "album_details_id")
    private AlbumDetails albumDetails;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToMany(mappedBy = "albumList")
    private List<Shop> shops = new ArrayList<>();

    public Album() {
    }

    public Album(String albumName, int albumQuantity) {
        this.albumName = albumName;
        this.albumQuantity = albumQuantity;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getAlbumQuantity() {
        return albumQuantity;
    }

    public void setAlbumQuantity(int albumQuantity) {
        this.albumQuantity = albumQuantity;
    }

    public AlbumDetails getAlbumDetails() {
        return albumDetails;
    }

    public void setAlbumDetails(AlbumDetails albumDetails) {
        this.albumDetails = albumDetails;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}

package com.example.ex1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shopId;
    private String location;

    @ManyToMany
    @JoinTable(name = "shop_album", joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id"))
    private List<Album> albumList = new ArrayList<>();

    public Shop() {
    }

    public Shop(String location) {
        this.location = location;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

}

package com.example.ex1;

import com.example.ex1.model.Album;
import com.example.ex1.model.AlbumDetails;
import com.example.ex1.model.Artist;
import com.example.ex1.model.Shop;
import com.example.ex1.repository.AlbumDetailsRepository;
import com.example.ex1.repository.AlbumRepository;
import com.example.ex1.repository.ArtistRepository;
import com.example.ex1.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Ex1Application implements CommandLineRunner {
    /**
     *
     * JPA => JAVA PERSISTENCE API
     *
     * JPQL => JAVA PERSISTENCE QUERY LANGUAGE
     *
     * Shop - album => many to many
     * artist - album => one to many
     * album - album details => one to one
     *
     * @OneToMany, @OneToOne, @ManyToMany, @ManyToOne
     *
     * relatiile se pot defini:
     *      -unidirectional
     *      -bidirectional
     *
     */
    @Autowired
    private AlbumDetailsRepository albumDetailsRepository;
    @Autowired
    private  AlbumRepository albumRepository;
    @Autowired
    private  ArtistRepository artistRepository;
    @Autowired
    private  ShopRepository shopRepository;


    public static void main(String[] args) {
        SpringApplication.run(Ex1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Artist artist1 = new Artist("Artist 1");
        Artist artist2 = new Artist("Artist 2");

        artistRepository.save(artist1);
        artistRepository.save(artist2);

        AlbumDetails albumDetails1 = new AlbumDetails("Some details for album1");
        AlbumDetails albumDetails2 = new AlbumDetails("Some details for album2");

        albumDetailsRepository.save(albumDetails1);
        albumDetailsRepository.save(albumDetails2);

        Album album1 = new Album("Album1", 5);
        Album album2 = new Album("Album2", 6);

        album1.setAlbumDetails(albumDetails1);
        album2.setAlbumDetails(albumDetails2);

        album1.setArtist(artist1);
        album2.setArtist(artist2);

        albumRepository.save(album1);
        albumRepository.save(album2);

        Shop shop = new Shop("Bucuresti sector 3");
        shop.setAlbumList(Arrays.asList(album1,album2));
        shopRepository.save(shop);

    }
}

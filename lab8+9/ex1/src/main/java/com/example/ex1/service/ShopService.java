package com.example.ex1.service;

import com.example.ex1.model.Album;
import com.example.ex1.model.AlbumDetails;
import com.example.ex1.model.Artist;
import com.example.ex1.model.Shop;
import com.example.ex1.repository.AlbumDetailsRepository;
import com.example.ex1.repository.AlbumRepository;
import com.example.ex1.repository.ArtistRepository;
import com.example.ex1.repository.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopService {
    private final AlbumDetailsRepository albumDetailsRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final ShopRepository shopRepository;


    public ShopService(AlbumDetailsRepository albumDetailsRepository, AlbumRepository albumRepository, ArtistRepository artistRepository, ShopRepository shopRepository){
        this.albumDetailsRepository = albumDetailsRepository;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.shopRepository = shopRepository;
    }

    public Artist saveNewArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public AlbumDetails saveAlbumDetails(AlbumDetails albumDetails) {
        return albumDetailsRepository.save(albumDetails);
    }

    public Album saveAlbum(Album album, int albumDetailsId, int artistId) {
        AlbumDetails albumDetails = albumDetailsRepository.findById(albumDetailsId)
                .orElseThrow(() -> new RuntimeException("Id is not a valid one!!!"));

        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new RuntimeException("Id is not a valid one!!!"));

        album.setAlbumDetails(albumDetails);
        album.setArtist(artist);

        return albumRepository.save(album);
    }

    public Shop saveShop(Shop shop, List<Integer> albumIds) {
        List<Album> albums = albumRepository.findAllById(albumIds);
        shop.setAlbumList(albums);
        return shopRepository.save(shop);
    }

    public List<Shop> retrieveShops() {
        return shopRepository.findAll();
    }

    public Album retrieveAlbumByName(String albumName) {
        return albumRepository.findAlbumByAlbumNameWithNativeQuery(albumName);
    }

    /**
     *
     * ACID
     * ATOMIC
     * CONSISTENCY
     * ISOLATED
     * DURABLE
     */

    @Transactional
    public String bulkLoadArtist(int n) {
        for(int i = 10 ; i < n; i++) {
            if(i == 15) {
                throw new RuntimeException("Some error has occurred on i =" + i);
            }
            Artist artist = new Artist("Artist" + i);
            artistRepository.save(artist);
        }
        return "OK!!!";
    }
}

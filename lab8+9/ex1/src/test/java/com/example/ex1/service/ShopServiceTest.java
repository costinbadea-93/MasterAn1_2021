package com.example.ex1.service;

import com.example.ex1.model.Album;
import com.example.ex1.model.AlbumDetails;
import com.example.ex1.model.Artist;
import com.example.ex1.repository.AlbumDetailsRepository;
import com.example.ex1.repository.AlbumRepository;
import com.example.ex1.repository.ArtistRepository;
import com.example.ex1.repository.ShopRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShopServiceTest {

    /**
     * @InjectMock
     * @Mock
     */
    @InjectMocks
    private ShopService shopService;

    @Mock
    private AlbumDetailsRepository albumDetailsRepository;
    @Mock
    private AlbumRepository albumRepository;
    @Mock
    private ArtistRepository artistRepository;
    @Mock
    private ShopRepository shopRepository;

    /**
     * @BeforeEach @AfterEach, @BeforeAll, @AfterAll
     */


    @Test
    @DisplayName("Running save Artist in a happy flow")
    void saveNewArtistHappyFlow(){
        //arrange - define actions for mocks
        Artist artist1 = new Artist("Artist Test1");
//        Artist artist2 = new Artist("Artist Test2");
        when(artistRepository.save(artist1)).thenReturn(artist1);
        //act - call the inject mock method
        Artist result = shopService.saveNewArtist(artist1);

        //assert - check the result based on arrange and act
        assertEquals(artist1.getArtistName(), result.getArtistName());
    }


    @Test
    @DisplayName("Running save album details in a happy flow")
    void saveNewAlbumDetailsHappyFlow(){
        //arrange
        AlbumDetails albumDetails = new AlbumDetails("Album details 1");

        when(albumDetailsRepository.save(albumDetails)).thenReturn(albumDetails);

        //act
        AlbumDetails result = shopService.saveAlbumDetails(albumDetails);

        //assert
        assertNotNull(result);
        assertEquals(albumDetails.getDescription(), result.getDescription());
    }


    @Test
    @DisplayName("Bulk load test negative flow")
    void bulkLoadTestNegativeFlow(){
        //arrange
        int n = 17;
        String response =  "Some error has occurred on i =15";

        //act
        RuntimeException result = assertThrows(
                RuntimeException.class,
                () -> shopService.bulkLoadArtist(n));


        //assert
        assertEquals(response, result.getMessage());
    }

    @Test
    @DisplayName("Save album using happy flow")
    void saveAlbumHappyFlow() {
        //arrange
        int albumDetailsId=1;
        int artistId=2;
        int albumQuantity = 5;

        Album album = new Album("Album1", albumQuantity);
        AlbumDetails albumDetails = new AlbumDetails("TestAlbumDetails");
        Artist artist = new Artist("TestArtist");

        when(albumDetailsRepository.findById(albumDetailsId)).thenReturn(Optional.of(albumDetails));
        when(artistRepository.findById(artistId)).thenReturn(Optional.of(artist));
        when(albumRepository.save(album)).thenReturn(album);

        //act
        Album result = shopService.saveAlbum(album,albumDetailsId,artistId);

        //assert
        assertEquals(album.getAlbumQuantity(), 5);
        assertEquals(album.getAlbumName(), result.getAlbumName());
        assertEquals(artist.getArtistName(), result.getArtist().getArtistName());
        assertEquals(albumDetails.getDescription(), result.getAlbumDetails().getDescription());
    }

    @Test
    @DisplayName("Save album using negative flow")
    void saveAlbumNegativeFlow() {
        //arrange
        int albumDetailsId=1;
        int artistId=2;
        int albumQuantity = 5;

        Album album = new Album("Album1", albumQuantity);
        AlbumDetails albumDetails = new AlbumDetails("TestAlbumDetails");
        Artist artist = new Artist("TestArtist");

        when(albumDetailsRepository.findById(albumDetailsId)).thenThrow(new RuntimeException("Some exception has occured"));

        //act
        try{
            Album result = shopService.saveAlbum(album,albumDetailsId,artistId);
        }catch (RuntimeException e) {
            assertEquals("Some exception has occured", e.getMessage());
            verify(artistRepository, times(0)).findById(artistId);
            verify(albumDetailsRepository, times(1)).findById(albumDetailsId);
        }

    }
}

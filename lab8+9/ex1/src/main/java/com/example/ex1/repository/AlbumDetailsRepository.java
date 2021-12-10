package com.example.ex1.repository;

import com.example.ex1.model.AlbumDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumDetailsRepository extends JpaRepository<AlbumDetails, Integer> {
}

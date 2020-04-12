package com.lgs.loader.repository;

import com.lgs.loader.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media, Long> {
    Optional<Media> findByFileName(String fileName);
}

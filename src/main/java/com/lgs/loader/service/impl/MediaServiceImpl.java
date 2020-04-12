package com.lgs.loader.service.impl;

import com.lgs.loader.entity.Media;
import com.lgs.loader.entity.MediaResponse;
import com.lgs.loader.exception.NotFoundException;
import com.lgs.loader.repository.MediaRepository;
import com.lgs.loader.service.MediaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RequiredArgsConstructor

@Service
@Slf4j
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;

    @Override
    public MediaResponse save(MultipartFile multipartFile) {
        Media media = new Media();
        media.setFileName(generateFilename());
        media.setType(multipartFile.getContentType());
        try {
            media.setData(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaRepository.save(media);

        return MediaResponse.builder()
                .fileName(media.getFileName())
                .url(generateUrl(media.getFileName()))
                .build();
    }

    private String generateUrl(String name) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/"+name).toUriString();

    }

    private String generateFilename() {
        return String.valueOf(System.nanoTime());
    }

    @Override
    public Media findByName(String name) {
        return mediaRepository.findByFileName(name).orElseThrow(
                () -> new NotFoundException("Media with name \""+name+"\" was NOT found."));
    }
}

package com.lgs.loader.controller.rest;

import com.lgs.loader.entity.Media;
import com.lgs.loader.entity.MediaResponse;
import com.lgs.loader.service.MediaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor

@RestController
@RequestMapping("api/media")
@Slf4j
public class MediaRestController {

    private final MediaService mediaService;

    @GetMapping("/{name}")
    public ResponseEntity<Resource> getFile(@PathVariable String name) {
        Media media = mediaService.findByName(name);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(media.getType()))
                .body(new ByteArrayResource(media.getData()));
    }

    @PostMapping()
    public MediaResponse saveFile(@RequestBody MultipartFile multipartFile, HttpServletRequest request) {
        return mediaService.save(multipartFile);
    }

}

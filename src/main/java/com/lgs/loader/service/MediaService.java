package com.lgs.loader.service;

import com.lgs.loader.entity.Media;
import com.lgs.loader.entity.MediaResponse;
import org.springframework.web.multipart.MultipartFile;

public interface MediaService {

    MediaResponse save(MultipartFile multipartFile);

    Media findByName(String name);

}

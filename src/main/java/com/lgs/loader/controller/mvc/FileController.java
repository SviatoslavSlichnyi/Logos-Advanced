package com.lgs.loader.controller.mvc;

import com.lgs.loader.entity.MediaResponse;
import com.lgs.loader.service.MediaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor

@Controller
@Slf4j
public class FileController {

    private final MediaService mediaService;

    @PostMapping("/file")
    public String saveFile(@RequestBody MultipartFile multipartFile, Model model) {
        MediaResponse response = mediaService.save(multipartFile);

        model.addAttribute("filePath", "api/media/"  + response.getFileName());

//        return "redirect:/api/media/"  + response.getFileName();
        return "download";
    }

}

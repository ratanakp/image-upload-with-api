package com.example.imageupload.controllers;

import com.example.imageupload.models.User;
import com.example.imageupload.services.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

    private UploadService uploadService;

    public MainController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @GetMapping("/upload")
    public String showUploadForm(Model model) {

        model.addAttribute("user", new User());

        return "upload-image";
    }

    @PostMapping("/upload/submit")
    @ResponseBody
    public String uploadFileSubmit(User user, @RequestParam(value = "file", required = false) MultipartFile file, @RequestParam(value = "file1", required = false) MultipartFile file1) {

        System.out.println(user);

        System.out.println(this.uploadService.upload(file));
        System.out.println(this.uploadService.upload(file1));

        return "Upload success!";
    }


}

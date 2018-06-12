package ua.com.likeshop.fb28.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.likeshop.fb28.entity.Image;
import ua.com.likeshop.fb28.repository.ImageRepository;

import java.io.IOException;

@RestController
public class ImageControlle {
    @Autowired
    ImageRepository imageRepository;

    @PostMapping("/image")
    public long addItem(@RequestParam ("file")MultipartFile file){
        Image images = new Image();
        try {
            images.setData(file.getBytes());
        } catch (IOException e) {
            return -1;
        }
        images = imageRepository.save(images);
        return images.getId();
    }
    @GetMapping("/image/{id}.png") ///?
    public byte[] showImg(@PathVariable("id") Long id){
        return imageRepository.findOne(id).getData();

    }
}

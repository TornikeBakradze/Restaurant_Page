package ge.restaurant.controller;

import ge.restaurant.impl.ImageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ImageController {
    @Autowired
    private ImageImpl image;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("image") List<MultipartFile> file,
                                         @RequestParam("id") String id) throws IOException {
        Long l = Long.parseLong(id);
        String uploadImage = image.uploadImageToFileSystem(file, l);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/image/{name}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable("name") String name) throws IOException {
        byte[] imageData = image.downloadImage(name);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpg"))
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

}

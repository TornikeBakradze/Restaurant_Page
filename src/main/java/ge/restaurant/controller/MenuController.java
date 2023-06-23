package ge.restaurant.controller;

import ge.restaurant.dto.CommentDto;
import ge.restaurant.dto.MenuDto;
import ge.restaurant.exception.DataAlreadyExistException;
import ge.restaurant.impl.ImageImpl;
import ge.restaurant.impl.MenuImpl;
import ge.restaurant.models.Menu_Items;
import ge.restaurant.models.Restaurant;
import ge.restaurant.repository.MenuRepository;
import ge.restaurant.repository.RatingRepository;
import ge.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class MenuController {
    @Autowired
    private MenuImpl menu;
    @Autowired
    private ImageImpl image;
    @PostMapping("/addMenu")
    public String add(@RequestBody List<MenuDto> menuDto) {
        try {
            menu.add(menuDto);
            return "Saved";
        }catch (DataAlreadyExistException e){
            return e.getMessage();
        }
    }

    @PostMapping("/addMenu/uploadImage")
    public ResponseEntity<?> uploadImage(@RequestParam("restaurantId") List<String> userId,
                                         @RequestParam("foodName") List<String> foodName,
                                         @RequestParam("image")List<MultipartFile> images) throws IOException {

        String uploadImage = image.uploadImage(userId, foodName, images);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }


}

package ge.restaurant.impl;

import ge.restaurant.dto.ManuImageUploaderDto;
import ge.restaurant.models.ImageData;
import ge.restaurant.models.Menu_Items;
import ge.restaurant.models.Restaurant;
import ge.restaurant.repository.ImageRepository;
import ge.restaurant.repository.MenuRepository;
import ge.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageImpl {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuRepository menuRepository;


    private final String FOLDER_PATH = "C:\\Users\\DELL\\Desktop\\MyFile";
    public String uploadImageToFileSystem(List<MultipartFile> files,Long id) throws IOException {
        Restaurant restaurant = restaurant(id);
        for (MultipartFile file : files) {
            UUID uuid=UUID.randomUUID();
            String name=uuid+"_"+file.getOriginalFilename();

            String filePath = FOLDER_PATH +"/"+ name;

            ImageData imageData = new ImageData(name,
                            file.getContentType(), filePath);
            restaurant.getImages().add(imageData);

            file.transferTo(new File(filePath));
            restaurantRepository.save(restaurant);
        }
        return "image uploaded successfully";
    }

    public byte[] downloadImage(String name) throws IOException {
        Optional<ImageData> imageData = imageRepository.findByName(name);
        String filePath=imageData.get().getFilePath();
        return Files.readAllBytes(new File(filePath).toPath());
    }


    public String uploadImage(List<String> id,List<String> foodName,List<MultipartFile> file) throws IOException {
        for (int i = 0; i < id.size(); i++) {
            Long l=Long.parseLong(id.get(i));
            String name=foodName.get(i);
            MultipartFile image=file.get(i);
            Menu_Items menuItems = menuRepository.findByNameAndID(name, l);
            UUID uuid=UUID.randomUUID();
            String imageName=uuid+"_"+image.getOriginalFilename().replaceAll("\\s","");
            String filePath = FOLDER_PATH +"/"+ imageName;
            ImageData imageData = new ImageData(imageName,
                    image.getContentType(), filePath);
            menuItems.setImageData(imageData);
            menuRepository.save(menuItems);
            image.transferTo(new File(filePath));
        }
        return "Image upload successfully";
    }

    private Restaurant restaurant(Long id){
        return restaurantRepository.findById(id).get();
    }
}

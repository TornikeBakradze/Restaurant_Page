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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.util.ResourceUtils;


@Service
public class ImageImpl {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuRepository menuRepository;


    public String uploadImageToFileSystem(List<MultipartFile> files, Long id) throws IOException {
        Restaurant restaurant = restaurant(id);
        ClassLoader classLoader = getClass().getClassLoader();
        File resourcesDirectory = new File(classLoader.getResource("assets/images").getPath());
        String folderPath = URLDecoder.decode(String.valueOf(resourcesDirectory), StandardCharsets.UTF_8);

        for (MultipartFile file : files) {
            UUID uuid = UUID.randomUUID();
            String name = uuid + "_" + file.getOriginalFilename();

            String filePath = folderPath + File.separator + name;

            ImageData imageData = new ImageData(name, file.getContentType(), filePath);
            restaurant.getImages().add(imageData);

            file.transferTo(new File(filePath));
            restaurantRepository.save(restaurant);
        }
        return "Image uploaded successfully";
    }

    public byte[] downloadImage(String name) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URI uri = null;
        try {
            uri = classLoader.getResource("assets/images").toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        String folderPath = Paths.get(uri).toString();
        String imageFilePath = folderPath + File.separator + name;

        Path imagePath = Paths.get(imageFilePath);
        return Files.readAllBytes(imagePath);
    }


    public String uploadImage(List<String> id, List<String> foodName, List<MultipartFile> files) throws IOException {
        for (int i = 0; i < id.size(); i++) {
            Long l = Long.parseLong(id.get(i));
            String name = foodName.get(i);
            MultipartFile file = files.get(i);

            Menu_Items menuItems = menuRepository.findByNameAndID(name, l);

            UUID uuid = UUID.randomUUID();
            String imageName = uuid + "_" + file.getOriginalFilename().replaceAll("\\s", "");

            String folderPath = ResourceUtils.getFile("classpath:assets/images").getAbsolutePath();
            String filePath = folderPath + File.separator + imageName;

            ImageData imageData = new ImageData(imageName, file.getContentType(), filePath);
            menuItems.setImageData(imageData);
            menuRepository.save(menuItems);

            file.transferTo(new File(filePath));
        }

        return "Image upload successfully";
    }

    private Restaurant restaurant(Long id) {
        return restaurantRepository.findById(id).get();
    }
}

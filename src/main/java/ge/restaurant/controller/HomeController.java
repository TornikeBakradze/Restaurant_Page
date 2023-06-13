package ge.restaurant.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
@CrossOrigin("*")
public class HomeController {
    @GetMapping("/")
    public String user() {
        return "Home level access";
    }
}

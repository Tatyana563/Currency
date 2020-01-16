package controller;

import model.City;
import model.Country;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;
//http://localhost:8080/currency/registration/new
@RestController
@RequestMapping("/registration")
public class UserRestController {
    @Autowired
    private UserService userService;
    @GetMapping("/new")
    public User create(
           // @RequestParam(value = "id", required = false) Integer id,
            @RequestParam("name") String name,
            @RequestParam("password") String password,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam(value="country", required = false) String country,
            @RequestParam(value="city", required = false) String city
    ){
final User user = new User();
user.setName(name);
user.setPassword(password);
City createdCity = City.valueOf(city);
Country createdCountry = Country.valueOf(country);
user.setCity(createdCity);
user.setCountry(createdCountry);
user.setEmail(email);
user.setPhone(phone);
return user;
    }
}

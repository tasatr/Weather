package weather;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IlmaController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
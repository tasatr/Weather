package weather;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @RequestMapping("/weather")
    public String index(@RequestParam(value="station", defaultValue="All") String station) {
        return "Get weather info for " + station;
    }

}
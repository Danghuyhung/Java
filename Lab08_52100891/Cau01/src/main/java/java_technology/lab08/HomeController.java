package java_technology.lab08;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() { return "index"; }

    @GetMapping("/contact")
    public String contact() { return "contact"; }

    @PostMapping("/contact")
    @ResponseBody
    public String getInfo(@RequestParam Map<String, String> body) {
        return body.toString();
    }
    @GetMapping("/about")
    public String about() { return "about"; }

}

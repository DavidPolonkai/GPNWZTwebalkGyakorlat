package hu.gpnwzt.springbootweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @PostMapping(value="/")
    public String postMethodName() {
        return "index";
    }
    


}
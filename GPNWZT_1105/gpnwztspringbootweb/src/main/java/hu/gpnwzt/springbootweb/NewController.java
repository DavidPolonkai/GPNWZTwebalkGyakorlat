package hu.gpnwzt.springbootweb;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewController {

    @GetMapping("/hello")
    public @ResponseBody String index(Model model) {
        return "Hello Spring Boot web world";
    }

    @GetMapping("/index={ID}")
    public @ResponseBody String GpnwztHello(@PathVariable(value = "ID") String id,Model model){
        return "Hello, "+id;
    } 

    @GetMapping("/add({a},{b})")
    public @ResponseBody String add(@PathVariable(value= "a") String a,@PathVariable(value= "b") String b){
        int ia = Integer.parseInt(a);
        int ib=Integer.parseInt(b);
        int res=ia+ib;
        return String.valueOf(res);
    }
}

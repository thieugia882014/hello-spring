package aptech.t008m.hellospring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @PostMapping (path = "/products")
    public String potData(){
        return "hi";
    }
}

package dev.java10x.HobbitCrud.Hobbits;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HobbitController {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }
}

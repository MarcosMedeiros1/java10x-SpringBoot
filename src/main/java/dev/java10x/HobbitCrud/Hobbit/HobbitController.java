package dev.java10x.HobbitCrud.Hobbit;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hobbit")
public class HobbitController {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }

    // Add Hobbit
    @PostMapping("/create")
    public String createHobbit() {
        return "Created!";
    }

    // Get Hobbit
    @GetMapping("all")
    public String getAllHobbits() {
        return "Showing all hobbits";
    }

    // Get Hobbit by ID
    @GetMapping("/hobbitId")
    public String getHobbitById() {
        return "Showing one specific hobbit";
    }

    // Update Hobbit data
    @PutMapping("/updateId")
    public String updateHobbitById() {
        return "Updated!";
    }

    // Delete Hobbit
    @DeleteMapping("/deleteId")
    public String deleteHobbitById() {
        return "Deleted!";
    }
}

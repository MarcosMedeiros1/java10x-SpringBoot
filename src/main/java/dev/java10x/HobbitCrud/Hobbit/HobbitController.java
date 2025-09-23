package dev.java10x.HobbitCrud.Hobbit;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hobbit")
public class HobbitController {

    private HobbitService hobbitService;

    public HobbitController(HobbitService hobbitService) {
        this.hobbitService = hobbitService;
    }

    // Add Hobbit
    @PostMapping("/create")
    public String createHobbit() {
        return "Created!";
    }

    // Get Hobbit
    @GetMapping("all")
    public List<HobbitModel> getAllHobbits() {
        return this.hobbitService.getAllHobbits();
    }

    // Get Hobbit by ID
    @GetMapping("/get/{id}")
    public HobbitModel getHobbitById(@PathVariable Long id) {
        return this.hobbitService.getHobbitById(id);
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

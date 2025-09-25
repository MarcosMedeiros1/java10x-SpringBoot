package dev.java10x.HobbitCrud.Hobbit;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hobbits")
public class HobbitController {

    private final HobbitService hobbitService;

    public HobbitController(HobbitService hobbitService) {
        this.hobbitService = hobbitService;
    }

    // Add Hobbit
    @PostMapping("/create")
    public HobbitModel createHobbit(@RequestBody HobbitModel hobbit) {
        return this.hobbitService.createHobbit(hobbit);
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
    @DeleteMapping("/delete/{id}")
    public void deleteHobbitById(@PathVariable Long id) {
        this.hobbitService.deleteHobbitById(id);
    }
}

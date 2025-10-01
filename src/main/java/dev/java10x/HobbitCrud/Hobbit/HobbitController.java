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
    public HobbitDTO createHobbit(@RequestBody HobbitDTO hobbitDTO) {
        return this.hobbitService.createHobbit(hobbitDTO);
    }

    // Get Hobbit
    @GetMapping("all")
    public List<HobbitDTO> getAllHobbits() {
        return this.hobbitService.getAllHobbits();
    }

    // Get Hobbit by ID
    @GetMapping("/get/{id}")
    public HobbitDTO getHobbitById(@PathVariable Long id) {
        return this.hobbitService.getHobbitById(id);
    }

    // Update Hobbit data
    @PutMapping("/update/{id}")
    public HobbitDTO updateHobbit(@PathVariable Long id, @RequestBody HobbitDTO hobbit) {
        return this.hobbitService.updateHobbit(id, hobbit);
    }

    // Delete Hobbit
    @DeleteMapping("/delete/{id}")
    public void deleteHobbitById(@PathVariable Long id) {
        this.hobbitService.deleteHobbitById(id);
    }
}

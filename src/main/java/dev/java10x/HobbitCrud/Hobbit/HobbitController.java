package dev.java10x.HobbitCrud.Hobbit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createHobbit(@RequestBody HobbitDTO hobbitDTO) {
        HobbitDTO newHobbit = hobbitService.createHobbit(hobbitDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Hobbit created: " + newHobbit.getName() + " - ID: " + newHobbit.getId());
    }

    // Get Hobbit
    @GetMapping("all")
    public ResponseEntity<List<HobbitDTO>> getAllHobbits() {
        List<HobbitDTO> hobbits = hobbitService.getAllHobbits();
        return ResponseEntity.ok(hobbits);
    }

    // Get Hobbit by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getHobbitById(@PathVariable Long id) {
        HobbitDTO hobbitDTO = hobbitService.getHobbitById(id);
        if (hobbitDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Hobbit with ID: " + id + " not found.");
        }
        return ResponseEntity.ok(hobbitDTO);
    }

    // Update Hobbit data
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateHobbit(@PathVariable Long id, @RequestBody HobbitDTO hobbit) {
        if (hobbitService.getHobbitById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Hobbit with ID: " + id + " not found.");
        }
        HobbitDTO hobbitDTO = hobbitService.updateHobbit(id, hobbit);
        return ResponseEntity.ok(hobbitDTO);
    }

    // Delete Hobbit
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHobbitById(@PathVariable Long id) {
        if (hobbitService.getHobbitById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Hobbit with ID: " + id + " not found.");
        }
        hobbitService.deleteHobbitById(id);
        return ResponseEntity.ok("Hobbit with ID: " + id + " deleted.");
    }
}

package dev.java10x.HobbitCrud.Hobbit;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hobbits")
public class HobbitController {

    private final HobbitService hobbitService;

    public HobbitController(HobbitService hobbitService) {
        this.hobbitService = hobbitService;
    }

    @PostMapping("/create")
    @Operation(summary = "Creates new Hobbit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Hobbit created"),
            @ApiResponse(responseCode = "400", description = "Error on create Hobbit")
    })
    public ResponseEntity<String> createHobbit(@RequestBody HobbitDTO hobbitDTO) {
        HobbitDTO newHobbit = hobbitService.createHobbit(hobbitDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Hobbit created: " + newHobbit.getName() + " - ID " + newHobbit.getId());
    }

    @GetMapping("/all")
    public ResponseEntity<List<HobbitDTO>> getAllHobbits() {
        List<HobbitDTO> hobbits = hobbitService.getAllHobbits();
        return ResponseEntity.ok(hobbits);
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Find Hobbit by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hobbit found"),
            @ApiResponse(responseCode = "404", description = "Hobbit not found")
    })
    public ResponseEntity<?> getHobbitById(@PathVariable Long id) {
        HobbitDTO hobbitDTO = hobbitService.getHobbitById(id);
        if (hobbitDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Hobbit with ID " + id + " not found.");
        }
        return ResponseEntity.ok(hobbitDTO);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Hobbit by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hobbit updated"),
            @ApiResponse(responseCode = "404", description = "Hobbit not found")
    })
    public ResponseEntity<?> updateHobbit(
            @Parameter(description = "Send ID on path")
            @PathVariable Long id,
            @RequestBody HobbitDTO hobbit)
    {
        if (hobbitService.getHobbitById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Hobbit with ID " + id + " not found.");
        }
        HobbitDTO hobbitDTO = hobbitService.updateHobbit(id, hobbit);
        return ResponseEntity.ok(hobbitDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHobbitById(@PathVariable Long id) {
        if (hobbitService.getHobbitById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Hobbit with ID " + id + " not found.");
        }
        hobbitService.deleteHobbitById(id);
        return ResponseEntity.ok("Hobbit with ID " + id + " deleted.");
    }
}

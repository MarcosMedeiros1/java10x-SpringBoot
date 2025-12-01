package dev.java10x.HobbitCrud.Mission;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MissionDTO>> getAllMissions() {
        List<MissionDTO> missions = missionService.getAllMissions();
        return ResponseEntity.ok(missions);
    }

    @PostMapping("/create")
    @Operation(summary = "Creates new Mission")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mission created"),
            @ApiResponse(responseCode = "400", description = "Error on create Mission")
    })
    public ResponseEntity<String> createMission(@RequestBody MissionDTO missionDTO) {
        MissionDTO newMission = missionService.createMission(missionDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Mission created: " + newMission.getName() + " - ID " + newMission.getId());
    }

    @PutMapping("/update")
    public String updateMission() {
        return "Mission updated!";
    }

    @DeleteMapping("")
    public String deleteMission() {
        return "Mission deleted!";
    }
}

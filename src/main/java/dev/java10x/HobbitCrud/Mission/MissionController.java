package dev.java10x.HobbitCrud.Mission;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Misssion by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mission updated"),
            @ApiResponse(responseCode = "404", description = "Mission not found")
    })
    public ResponseEntity<?> updateMission(
            @Parameter(description = "Send ID on path")
            @PathVariable Long id,
            @RequestBody MissionDTO mission)
    {
        if (missionService.getMissionById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission with ID " + id + " not found.");
        }
        MissionDTO missionDTO = missionService.updateMission(id, mission);
        return ResponseEntity.ok(missionDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMission(@PathVariable Long id) {
        if (missionService.getMissionById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission with ID " + id + " not found.");
        }
        missionService.deleteMissionById(id);
        return ResponseEntity.ok("Mission with ID " + id + " deleted.");
    }
}

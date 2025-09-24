package dev.java10x.HobbitCrud.Mission;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missions")
public class MissionController {

    @GetMapping("/all")
    public String getAllMissions() {
        return "all missions";
    }

    @PostMapping("/create")
    public String createMission() {
        return "mission created!";
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

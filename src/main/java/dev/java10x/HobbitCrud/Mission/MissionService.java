package dev.java10x.HobbitCrud.Mission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;

    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    public List<MissionDTO> getAllMissions() {
        List<MissionModel> missions = missionRepository.findAll();
        return missions.stream()
                .map(missionMapper::map)
                .collect(Collectors.toList());
    }

    public MissionDTO getMissionById(Long id) {
        Optional<MissionModel> mission = missionRepository.findById(id);
        return mission.map(missionMapper::map).orElse(null);
    }

    public MissionDTO createMission(MissionDTO missionDTO) {
        MissionModel mission = missionMapper.map(missionDTO);
        mission = missionRepository.save(mission);
        return missionMapper.map(mission);
    }

    public void deleteMissionById(Long id) { missionRepository.deleteById(id); }

    public MissionDTO updateMission(Long id, MissionDTO missionDTO) {
        Optional<MissionModel> foundMission = missionRepository.findById(id);
        if (foundMission.isPresent()) {
            MissionModel updatedMission = missionMapper.map(missionDTO);
            updatedMission.setId(id);
            MissionModel savedMission = missionRepository.save(updatedMission);
            return missionMapper.map(savedMission);
        }
        return  null;
    }
}

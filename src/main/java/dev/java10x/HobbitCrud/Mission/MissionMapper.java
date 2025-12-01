package dev.java10x.HobbitCrud.Mission;
import org.springframework.stereotype.Component;

@Component
public class MissionMapper {

    public MissionModel map(MissionDTO missionDTO) {

        MissionModel missionModel = new MissionModel();

        missionModel.setId(missionDTO.getId());
        missionModel.setName(missionDTO.getName());
        missionModel.setDifficulty(missionDTO.getDifficulty());
        missionModel.setHobbits(missionDTO.getHobbits());

        return missionModel;
    }

    public MissionDTO map(MissionModel missionModel) {

        MissionDTO missionDTO = new MissionDTO();

        missionDTO.setId(missionModel.getId());
        missionDTO.setName(missionModel.getName());
        missionDTO.setDifficulty(missionModel.getDifficulty());
        missionDTO.setHobbits(missionModel.getHobbits());

        return missionDTO;
    }
}

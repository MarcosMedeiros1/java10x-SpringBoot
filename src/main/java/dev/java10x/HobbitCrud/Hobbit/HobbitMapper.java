package dev.java10x.HobbitCrud.Hobbit;

import org.springframework.stereotype.Component;

@Component
public class HobbitMapper {

    public HobbitModel map(HobbitDTO hobbitDTO) {

        HobbitModel hobbitModel = new HobbitModel();

        hobbitModel.setId(hobbitDTO.getId());
        hobbitModel.setName(hobbitDTO.getName());
        hobbitModel.setLevel(hobbitDTO.getLevel());
        hobbitModel.setEmail(hobbitDTO.getEmail());
        hobbitModel.setAge(hobbitDTO.getAge());
        hobbitModel.setMissions(hobbitDTO.getMissions());

        return hobbitModel;
    }

    public HobbitDTO map(HobbitModel hobbitModel) {

        HobbitDTO hobbitDTO = new HobbitDTO();

        hobbitDTO.setName(hobbitModel.getName());
        hobbitDTO.setId(hobbitModel.getId());
        hobbitDTO.setName(hobbitModel.getName());
        hobbitDTO.setLevel(hobbitModel.getLevel());
        hobbitDTO.setEmail(hobbitModel.getEmail());
        hobbitDTO.setAge(hobbitModel.getAge());
        hobbitDTO.setMissions(hobbitModel.getMissions());

        return hobbitDTO;
    }
}

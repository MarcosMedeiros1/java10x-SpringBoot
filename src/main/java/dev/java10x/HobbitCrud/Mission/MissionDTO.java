package dev.java10x.HobbitCrud.Mission;
import dev.java10x.HobbitCrud.Hobbit.HobbitModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionDTO {

    private Long id;
    private String name;
    private String difficulty;
    private List<HobbitModel> hobbits;
}

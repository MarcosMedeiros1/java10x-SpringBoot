package dev.java10x.HobbitCrud.Hobbit;

import dev.java10x.HobbitCrud.Mission.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HobbitDTO {

    private Long id;
    private String name;
    private String level;
    private String email;
    private int age;
    private MissionModel missions;
}

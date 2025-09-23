package dev.java10x.HobbitCrud.Mission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.HobbitCrud.Hobbit.HobbitModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "difficulty")
    private String difficulty;

    @OneToMany(mappedBy = "missions")
    @JsonIgnore
    private List<HobbitModel> hobbits;
}

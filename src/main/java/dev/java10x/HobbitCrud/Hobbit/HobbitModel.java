package dev.java10x.HobbitCrud.Hobbit;

import dev.java10x.HobbitCrud.Mission.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_hobbits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missions")
public class HobbitModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private String level;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private MissionModel missions;
}

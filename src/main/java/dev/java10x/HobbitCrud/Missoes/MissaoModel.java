package dev.java10x.HobbitCrud.Missoes;

import dev.java10x.HobbitCrud.Hobbits.HobbitModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;
    @OneToMany(mappedBy = "missoes")
    private List<HobbitModel> hobbits;
}

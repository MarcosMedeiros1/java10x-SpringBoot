package dev.java10x.HobbitCrud.Hobbits;

import dev.java10x.HobbitCrud.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_hobbits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HobbitModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;
    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissaoModel missoes;
}

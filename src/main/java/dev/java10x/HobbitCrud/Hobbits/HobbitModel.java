package dev.java10x.HobbitCrud.Hobbits;

import dev.java10x.HobbitCrud.Missoes.MissaoModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_hobbits")
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

    public HobbitModel() {
    }

    public HobbitModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

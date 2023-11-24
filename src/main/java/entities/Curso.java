package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int carga_horaria;

    @ManyToMany
    @JoinTable(
            name = "tb_aluno_curso",
            joinColumns = @JoinColumn(name="matricula"),
            inverseJoinColumns={@JoinColumn(name = "id")}

    )
    private Set<Aluno> aluno = new HashSet<>();

    public Curso(Long id, String nome, int carga_horaria) {
        this.id = id;
        this.nome = nome;
        this.carga_horaria = carga_horaria;
    }

    public  Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }
}

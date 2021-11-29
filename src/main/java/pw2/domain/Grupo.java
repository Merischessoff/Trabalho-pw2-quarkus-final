package pw2.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@SequenceGenerator(name = "GRU_SEQ", sequenceName = "GRUPO_SEQ", initialValue = 1, allocationSize = 1)
public class Grupo extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRU_SEQ")
    private Long idGrupo;
    private String grupo;
    private String descricao;


    public Grupo() {
    }


    public Grupo(String grupo, String descricao) {
        this.grupo = grupo;
        this.descricao = descricao;
    }


    public String getGrupo() {
        return this.grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Long getIdGrupo() {
        return this.idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Grupo)) {
            return false;
        }
        Grupo grupo = (Grupo) o;
        return Objects.equals(grupo, grupo.grupo) && Objects.equals(descricao, grupo.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grupo, descricao);
    }


    @Override
    public String toString() {
        return "{" +
            " grupo='" + getGrupo() + "'" +
            ", descricao='" + getDescricao() + "'" +
            "}";
    }


}

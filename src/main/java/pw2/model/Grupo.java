package pw2.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Grupo extends PanacheEntity{
    private String grupo;
    private String descricao;

	@ManyToMany(mappedBy="grupos", fetch = FetchType.EAGER)
    @JsonManagedReference
	private List<Destinatario> destinatarios;
    
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

    public List<Destinatario> getDestinatarios() {
        return this.destinatarios;
    }

    public void setDestinatarios(List<Destinatario> destinatarios) {
        this.destinatarios = destinatarios;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Grupo)) {
            return false;
        }
        Grupo grupo = (Grupo) o;
        return Objects.equals(descricao, grupo.descricao) 
        & Objects.equals(destinatarios, grupo.destinatarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grupo, descricao, destinatarios);
    }


    @Override
    public String toString() {
        return "{" +
            " grupo='" + getGrupo() + "'" +
            ", descricao='" + getDescricao() + "'" +
            "}";
    }


}

package pw2.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@SequenceGenerator(name = "GRU_SEQ", sequenceName = "GRUPO_SEQ", initialValue = 1, allocationSize = 1)
public class Grupo extends PanacheEntityBase{
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRU_SEQ")
    private Long idGrupo;
    private String grupo;
    private String descricao;

    // @JsonIgnore
	// @ManyToMany
	// @JoinTable(name = "Informativo_Grupo",
	// 	joinColumns = @JoinColumn(name = "idGrupo"),
	// 	inverseJoinColumns = @JoinColumn(name = "idInformativo")
	// )
    // private List<Informativo> informativos;

    @JsonIgnore
	@ManyToMany
	@JoinTable(name = "Grupo_Destinatario",
		joinColumns = @JoinColumn(name = "idGrupo"),
		inverseJoinColumns = @JoinColumn(name = "idDestinatario")
	)
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


    public Long getIdGrupo() {
        return this.idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }


    // public List<Informativo> getInformativos() {
    //     return this.informativos;
    // }

    // public void setInformativos(List<Informativo> informativos) {
    //     this.informativos = informativos;
    // }

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
        return Objects.equals(idGrupo, grupo.idGrupo) 
        && Objects.equals(descricao, grupo.descricao) 
        & Objects.equals(destinatarios, grupo.destinatarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGrupo, grupo, descricao, destinatarios);
    }

    

    @Override
    public String toString() {
        return "{" +
            " grupo='" + getGrupo() + "'" +
            ", descricao='" + getDescricao() + "'" +
            "}";
    }


}

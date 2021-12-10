package pw2.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Destinatario extends PanacheEntity{
    
    private String cpf;
    private String nome;
    
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
	private List<Grupo> grupos;

	@ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
	private List<Informativo> informativos;

    public Destinatario() {
    }

    public Destinatario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public List<Grupo> getGrupos() {
        return this.grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public List<Informativo> getInformativos() {
        return this.informativos;
    }

    public void setInformativos(List<Informativo> informativos) {
        this.informativos = informativos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Destinatario)) {
            return false;
        }
        Destinatario destinatario = (Destinatario) o;
        return Objects.equals(cpf, destinatario.cpf) && Objects.equals(nome, destinatario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome);
    }


    @Override
    public String toString() {
        return "{" +
            " cpf='" + getCpf() + "'" +
            ", nome='" + getNome() + "'" +
            "}";
    }

}

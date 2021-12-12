package pw2.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Destinatario extends PanacheEntityBase{
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    private Long idDestinatario;
    private String cpf;
    private String nome;
    
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
	private List<Grupo> grupos;

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

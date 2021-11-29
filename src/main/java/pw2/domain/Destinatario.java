package pw2.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@SequenceGenerator(name = "DEST_SEQ", sequenceName = "DESTINATARIO_SEQ", initialValue = 1, allocationSize = 1)
public class Destinatario extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEST_SEQ")
    private Long idDestinario;
    private String cpf;
    private String nome;


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


    public Long getIdDestinario() {
        return this.idDestinario;
    }

    public void setIdDestinario(Long idDestinario) {
        this.idDestinario = idDestinario;
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

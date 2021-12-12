package pw2.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Usuario extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    private Long idUsuario;
    private String cpf;
    private String nome;
    private String login;
    private String senha;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="idUsuario")
	private List<Informativo> informativos;

    public Usuario() {
    }


    public Usuario(Long idUsuario, String cpf, String nome, String login, String senha, List<Informativo> informativos) {
        this.idUsuario = idUsuario;
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.informativos = informativos;
    }


    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Informativo> getInformativos() {
        return this.informativos;
    }

    public void setInformativos(Informativo informativo) {
        this.informativos.add(informativo);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario) && Objects.equals(cpf, usuario.cpf) && Objects.equals(nome, usuario.nome) && Objects.equals(login, usuario.login) && Objects.equals(senha, usuario.senha) && Objects.equals(informativos, usuario.informativos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, cpf, nome, login, senha, informativos);
    }

    @Override
    public String toString() {
        return "{" +
            " idUsuario='" + getIdUsuario() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", nome='" + getNome() + "'" +
            ", login='" + getLogin() + "'" +
            ", senha='" + getSenha() + "'" +
            ", informativos='" + getInformativos() + "'" +
            "}";
    }

}

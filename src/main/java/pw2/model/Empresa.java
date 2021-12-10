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
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Empresa extends PanacheEntity{
    
    private String cnpj;
    private String razaoSocial;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="idEmpresa")
	private List<Usuario> usuarios;

    public Empresa() {
    }

    public Empresa(String cnpj, String razaoSocial) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }


    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empresa)) {
            return false;
        }
        Empresa empresa = (Empresa) o;
        return Objects.equals(cnpj, empresa.cnpj) && Objects.equals(razaoSocial, empresa.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj, razaoSocial);
    }


    @Override
    public String toString() {
        return "{" +
            " cnpj='" + getCnpj() + "'" +
            ", razaoSocial='" + getRazaoSocial() + "'" +
            "}";
    }

}

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

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@SequenceGenerator(name = "EMP_SEQ", sequenceName = "EMPRESA_SEQ", initialValue = 1, allocationSize = 1)
public class Empresa extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_SEQ")
    private Long idEmpresa;
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


    public Long getIdEmpresa() {
        return this.idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
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

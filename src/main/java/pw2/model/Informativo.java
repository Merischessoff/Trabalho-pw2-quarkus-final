package pw2.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@SequenceGenerator(name = "INF_SEQ", sequenceName = "INFORMATIVO_SEQ", initialValue = 1, allocationSize = 1)
public class Informativo extends PanacheEntityBase{
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INF_SEQ")
    private Long idInformativo;
    private String texto;
    private String imagem;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
	private List<Destinatario> destinatarios;
    
    public Informativo() {
    }

    public Informativo(String texto, String imagem) {
        this.texto = texto;
        this.imagem = imagem;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Long getIdInformativo() {
        return this.idInformativo;
    }

    public void setIdInformativo(Long idInformativo) {
        this.idInformativo = idInformativo;
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
        if (!(o instanceof Informativo)) {
            return false;
        }
        Informativo informativo = (Informativo) o;
        return Objects.equals(texto, informativo.texto) 
        && Objects.equals(imagem, informativo.imagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto, imagem);
    }


    @Override
    public String toString() {
        return "{" +
            " texto='" + getTexto() + "'" +
            ", imagem='" + getImagem() + "'" +
            "}";
    }


    
}

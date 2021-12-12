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
public class Informativo extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    private Long idInformativo;
    private String texto;
    private String imagem;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="idInformativo")
	private List<Destinatario> destinatarios;
    
    public Informativo() {
    }


    public Informativo(Long idInformativo, String texto, String imagem, List<Destinatario> destinatarios) {
        this.idInformativo = idInformativo;
        this.texto = texto;
        this.imagem = imagem;
        this.destinatarios = destinatarios;
    }

    public Long getIdInformativo() {
        return this.idInformativo;
    }

    public void setIdInformativo(Long idInformativo) {
        this.idInformativo = idInformativo;
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
        return Objects.equals(idInformativo, informativo.idInformativo) && Objects.equals(texto, informativo.texto) && Objects.equals(imagem, informativo.imagem) && Objects.equals(destinatarios, informativo.destinatarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInformativo, texto, imagem, destinatarios);
    }
    

    @Override
    public String toString() {
        return "{" +
            " idInformativo='" + getIdInformativo() + "'" +
            ", texto='" + getTexto() + "'" +
            ", imagem='" + getImagem() + "'" +
            ", destinatarios='" + getDestinatarios() + "'" +
            "}";
    }
    
}

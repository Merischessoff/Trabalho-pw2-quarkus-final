package pw2.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Informativo extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    private Long idInformativo;
    private String texto;
    private String imagem;


    @ManyToMany(mappedBy="informativos", fetch = FetchType.EAGER)
    @JsonManagedReference
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

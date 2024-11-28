package UD3.Avanzado.GenEsquema;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AutorLibroId implements Serializable {
    private static final long serialVersionUID = 4435460300962619210L;
    @Column(name = "id_autor", nullable = false)
    private Long idAutor;

    @Column(name = "id_libro", nullable = false)
    private Long idLibro;


    public AutorLibroId() {
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AutorLibroId entity = (AutorLibroId) o;
        return Objects.equals(this.idLibro, entity.idLibro) &&
                Objects.equals(this.idAutor, entity.idAutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLibro, idAutor);
    }

}
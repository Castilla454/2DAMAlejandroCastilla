package UD3.Avanzado.GenEsquema;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "autor_libro")
public class AutorLibro {
    @EmbeddedId
    private AutorLibroId id;

    @MapsId("idAutor")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor idAutor;

    @MapsId("idLibro")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_libro", nullable = false)
    private Libro idLibro;


    public AutorLibro() {
    }

    public AutorLibroId getId() {
        return id;
    }

    public void setId(AutorLibroId id) {
        this.id = id;
    }

    public Autor getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autor idAutor) {
        this.idAutor = idAutor;
    }

    public Libro getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Libro idLibro) {
        this.idLibro = idLibro;
    }

}
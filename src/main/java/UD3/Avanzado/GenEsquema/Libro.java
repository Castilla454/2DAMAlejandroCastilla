package UD3.Avanzado.GenEsquema;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "isbn", length = 20)
    private String isbn;

    @Column(name = "categoria", length = 100)
    private String categoria;

    @Column(name = "anio_public")
    private Short anioPublic;

    @ManyToMany(mappedBy = "libros")
    private Set<Autor> autors = new LinkedHashSet<>();


    public Libro() {
    }

    public Long getId() {
        return id;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Short getAnioPublic() {
        return anioPublic;
    }

    public void setAnioPublic(Short anioPublic) {
        this.anioPublic = anioPublic;
    }

    public Set<Autor> getAutors() {
        return autors;
    }

    public void setAutors(Set<Autor> autors) {
        this.autors = autors;
    }

}
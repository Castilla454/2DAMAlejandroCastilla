package UD1;

import java.io.Serializable;
import java.util.Objects;

public class Modulo implements Serializable, Comparable<Modulo> {
    private static final long serialVersionUID = 5126642041982425623L;
    private String nombre;
    private int numHoras;
    private double nota;


    public Modulo(String nombre, int numHoras, double nota) {
        this.nombre = nombre;
        this.numHoras = numHoras;
        this.nota = nota;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modulo modulo = (Modulo) o;
        return numHoras == modulo.numHoras && Double.compare(nota, modulo.nota) == 0 && Objects.equals(nombre, modulo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, numHoras, nota);
    }

    @Override
    public String toString() {
        return "UD1.Modulo{" +
                "nombre='" + nombre + '\'' +
                ", numHoras=" + numHoras +
                ", nota=" + nota +
                '}' + "\n";
    }


    @Override
    public int compareTo(Modulo m) {
        int resultado = CharSequence.compare(this.nombre, (m.getNombre()));
        if (resultado == 0) {
            resultado = Integer.compare(this.numHoras, m.getNumHoras());
            if (resultado == 0) {
                resultado = Double.compare(this.nota, m.getNota());
            }
        }
        return resultado;
    }
}

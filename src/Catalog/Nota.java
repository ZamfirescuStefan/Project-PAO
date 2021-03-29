package Catalog;

public class Nota {
    private Integer nota;

    public Nota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nota.toString();
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}

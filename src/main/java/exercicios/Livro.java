package exercicios;

public class Livro {
    private String titulo;
    private String autor;
    private src.exercicios.apis.Editora editora;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public src.exercicios.apis.Editora getEditora() {
        return editora;
    }

    public void setEditora(src.exercicios.apis.Editora editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora=" + editora +
                '}';
    }
}
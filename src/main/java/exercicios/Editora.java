package src.exercicios.apis;

public class Editora {
    private String nomeEditora;

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    @Override
    public String toString() {
        return "Editora{" +
                "nomeEditora='" + nomeEditora + '\'' +
                '}';
    }
}
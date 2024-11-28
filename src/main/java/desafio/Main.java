package desafio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite um CEP: ");
        String cep = leitura.nextLine();

        metodos metodos = new metodos();
        Endereco endereco = metodos.buscaCep(cep);
        System.out.println(endereco);
        GeradorArquivo geradorArquivo = new GeradorArquivo();
        geradorArquivo.geraArquivoJson(endereco);
    }
}

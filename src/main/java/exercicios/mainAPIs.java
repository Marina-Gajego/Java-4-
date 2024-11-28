package exercicios;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//Crie um programa em Java que utilize as classes HttpClient, HttpRequest e HttpResponse para fazer uma consulta a API do Google Books. Solicite ao usuario que insira o titulo de um livro, e exiba as informacoes disponiveis sobre o livro retornado pela API.
//Crie um programa Java que utiliza as classes HttpClient, HttpRequest e HttpResponse para fazer uma consulta a API CoinGecko e exiba a cotacao atual de uma criptomoeda escolhida pelo usuario.
//Crie um programa Java que faca uma consulta a API do TheMealDB utilizando as classes HttpClient, HttpRequest e HttpResponse. Solicite ao usuario que insira o nome de uma receita e exiba as informacoes disponiveis sobre essa receita.
//Crie uma classe Pessoa usando o conceito de Record em Java, com atributos como nome, idade e cidade. Em seguida, implemente um programa que utiliza a biblioteca Gson para converter um JSON representando uma pessoa em um objeto do tipo Pessoa.
//Modifique o programa do Exercicio anterior para permitir a conversao de um JSON mesmo se alguns campos estiverem ausentes ou se houver campos adicionais nao representados no objeto Pessoa. Consulte a documentacao da biblioteca Gson para flexibilizar a conversao.
//Crie uma classe Livro.java que contenha atributos como titulo, autor e um objeto representando a editora. Em seguida, implemente um programa que utiliza a biblioteca Gson para converter um JSON aninhado representando um livro em um objeto do tipo Livro.java.

public class mainAPIs {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        System.out.println("Insira um título de um livro: ");
        String titulo = leitura.nextLine().replace(" ", "+"); // Formata o título para a URL

        String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + titulo;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status da resposta: " + response.statusCode());
            System.out.println("Conteúdo da resposta: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");

        System.out.println("Digite o nome de uma criptomoeda: ");
        String moeda = leitura.nextLine();

        String endereco1 = "https://api.coingecko.com/api/v3/simple/price?ids=" + moeda + "&vs_currencies=brl";

        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create(endereco1))
                .build();

        try{
            HttpResponse<String> response = client.send(request1, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");

        System.out.println("Digite o nome de uma receita: ");
        String receita = leitura.nextLine().replace(" ", "_");

        String endereco2 = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + receita;

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(endereco2))
                .build();

        try{
            HttpResponse<String> response = client.send(request2, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");

        String json = "{\"nome\":\"João\",\"idade\":30,\"cidade\":\"São Paulo\"}";
        Gson gson = new GsonBuilder().setLenient().create();


        Pessoa pessoa = gson.fromJson(json, Pessoa.class);

        System.out.println(pessoa);
        System.out.println("Nome: " + pessoa.nome());
        System.out.println("Idade: " + pessoa.idade());
        System.out.println("Cidade: " + pessoa.cidade());
        System.out.println("------------------------------------------------------------------------------------------------------------");

        String jsonLivro = "{ \"titulo\": \"O Alquimista\", \"autor\": \"Paulo Coelho\", \"editora\": { \"nomeEditora\": \"HarperCollins\"} }";
        Livro livro = gson.fromJson(jsonLivro, Livro.class);

        System.out.println(livro);
        System.out.println("Nome do livro: " + livro.getTitulo() + " Autor do livro: " + livro.getAutor() + "Editora: " + livro.getEditora());

    }
}
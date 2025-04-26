package com.aluracursos.screenmatch.main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            HttpClient client = HttpClient.newHttpClient();

            System.out.println("Escriba el nombre de la película:");
            var search = scanner.nextLine();
            String url = "http://www.omdbapi.com/?apikey=9c53b1c8&t=" + search;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

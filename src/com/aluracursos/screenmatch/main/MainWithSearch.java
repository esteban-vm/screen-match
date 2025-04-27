package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.models.Title;
import com.google.gson.Gson;

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

            String json = response.body();
            System.out.println(json);

            Gson gson = new Gson();
            var title = gson.fromJson(json, Title.class);
            System.out.println(title);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

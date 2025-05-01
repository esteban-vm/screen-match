package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.exceptions.DurationException;
import com.aluracursos.screenmatch.models.Title;
import com.aluracursos.screenmatch.models.TitleOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Title> titles = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {
            try {
                HttpClient client = HttpClient.newHttpClient();

                System.out.println("Escriba el nombre de la película:");

                var search = scanner.nextLine();
                if (search.equalsIgnoreCase("salir")) break;

                String url = "http://www.omdbapi.com/?apikey=9c53b1c8&t="
                        + URLEncoder.encode(search, StandardCharsets.UTF_8);

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                var titleOMDB = gson.fromJson(json, TitleOMDB.class);
                System.out.println("Título no convertido: " + titleOMDB);

                var title = new Title(titleOMDB);
                System.out.println("Título ya convertido: " + title);

                titles.add(title);
            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println("Error en la URI");
            } catch (DurationException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Nombre del error: " + e.getClass().getSimpleName());
                System.out.println("Mensaje de error: " + e.getLocalizedMessage());
            } finally {
                System.out.println("****************************");
            }
        }

        scanner.close();
        System.out.println(titles);

        try {
            FileWriter writer = new FileWriter("movies.json");
            writer.write(gson.toJson(titles));
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println("Finalizó la ejecución del programa");
    }
}

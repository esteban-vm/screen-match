package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.exceptions.DurationException;
import com.aluracursos.screenmatch.models.Title;
import com.aluracursos.screenmatch.models.TitleOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            HttpClient client = HttpClient.newHttpClient();

            System.out.println("Escriba el nombre de la película:");
            var search = scanner.nextLine();

            String url = "http://www.omdbapi.com/?apikey=9c53b1c8&t="
                    + URLEncoder.encode(search, StandardCharsets.UTF_8);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            // Gson gson = new Gson();

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            var titleOMDB = gson.fromJson(json, TitleOMDB.class);
            System.out.println(titleOMDB);

            var title = new Title(titleOMDB);
            System.out.println("Título ya convertido: " + title);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Error en la URI");
        } catch (DurationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Nombre del error: " + e.getClass().getSimpleName());
            System.out.println("Mensaje de error: " + e.getLocalizedMessage());
        } finally {
            System.out.println("Finalizó la ejecución del programa");
        }
    }
}

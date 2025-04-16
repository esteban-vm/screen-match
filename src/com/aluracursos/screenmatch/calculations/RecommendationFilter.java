package com.aluracursos.screenmatch.calculations;

public class RecommendationFilter {
    public void filter(Classifiable classifiable) {
        int classification = classifiable.getClassification();

        if (classification >= 4) {
            System.out.println("Top");
        } else if (classification >= 2) {
            System.out.println("Popular");
        } else {
            System.out.println("Ver más tarde");
        }
    }
}

package dev.alejandro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        var travelers = List.of(
                new Traveler("Alex", Set.of(
                        new Trip("France"),
                        new Trip("Germany"),
                        new Trip("Spain")
                )),
                new Traveler("Marian", Set.of(
                        new Trip("Argentina"),
                        new Trip("Brazil")
                ))
        );

        System.out.println("### Without streams ###");
        withoutStreams(travelers);
        System.out.println("### With streams ###");
        withStreams(travelers);

    }

    private static void withoutStreams(List<Traveler> travelers) {

        System.out.println("Traveler names:");
        List<String> travelerNames = new ArrayList<>();
        for (var traveler: travelers) {
            travelerNames.add(traveler.name());
        }
        travelerNames.forEach(System.out::println);

        System.out.println("Trip names:");
        List<String> tripNames = new ArrayList<>();
        for (var traveler: travelers) {
            for (var trip: traveler.trips()) {
                tripNames.add(trip.name());
            }
        }
        tripNames.forEach(System.out::println);
    }

    private static void withStreams(List<Traveler> travelers) {

        System.out.println("Traveler names:");
        travelers
                .stream()
                .map(Traveler::name)
                .forEach(System.out::println);

        System.out.println("Trip names:");
        travelers
                .stream()
                .map(Traveler::trips)
                .flatMap(Collection::stream)
                .map(Trip::name)
                .forEach(System.out::println);
    }
}

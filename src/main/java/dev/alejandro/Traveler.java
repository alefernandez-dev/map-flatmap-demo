package dev.alejandro;

import java.util.Set;

public record Traveler(String name, Set<Trip> trips) {
}

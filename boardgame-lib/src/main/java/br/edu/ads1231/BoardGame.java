package br.edu.ads1231;

import java.util.Objects;

public class BoardGame {
    private final String id;
    private final String name;
    private final int minPlayers;
    private final int maxPlayers;
    private final int year;
    private final String publisher;

    public BoardGame(String id, String name, int minPlayers, int maxPlayers, int year, String publisher) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id obrigatório");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name obrigatório");
        if (minPlayers < 1) throw new IllegalArgumentException("minPlayers deve ser >= 1");
        if (maxPlayers < minPlayers) throw new IllegalArgumentException("maxPlayers >= minPlayers");
        if (year <= 0) throw new IllegalArgumentException("year deve ser > 0");
        this.id = id.trim();
        this.name = name.trim();
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.year = year;
        this.publisher = (publisher == null) ? "" : publisher.trim();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getMinPlayers() { return minPlayers; }
    public int getMaxPlayers() { return maxPlayers; }
    public int getYear() { return year; }
    public String getPublisher() { return publisher; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardGame)) return false;
        BoardGame that = (BoardGame) o;
        return id.equalsIgnoreCase(that.id);
    }

    @Override public int hashCode() { return Objects.hash(id.toLowerCase()); }

    @Override public String toString() {
        return name + " (" + year + ") [" + minPlayers + "-" + maxPlayers + "]";
    }
}

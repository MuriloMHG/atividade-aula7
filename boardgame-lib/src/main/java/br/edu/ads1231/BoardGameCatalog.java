package br.edu.ads1231;

import java.util.*;
import java.util.stream.Collectors;

public class BoardGameCatalog {
    private final Map<String, BoardGame> byId = new HashMap<>();

    public void add(BoardGame game) {
        Objects.requireNonNull(game, "game não pode ser null");
        String key = game.getId().toLowerCase();
        if (byId.containsKey(key)) {
            throw new IllegalArgumentException("id já existente: " + game.getId());
        }
        byId.put(key, game);
    }

    public Optional<BoardGame> findById(String id) {
        if (id == null) return Optional.empty();
        return Optional.ofNullable(byId.get(id.toLowerCase()));
    }

    public List<BoardGame> searchByName(String nameFragment) {
        String needle = (nameFragment == null) ? "" : nameFragment.trim().toLowerCase();
        return byId.values().stream()
                .filter(g -> g.getName().toLowerCase().contains(needle))
                .sorted(Comparator.comparing(BoardGame::getName))
                .collect(Collectors.toList());
    }

    public boolean remove(String id) {
        if (id == null) return false;
        return byId.remove(id.toLowerCase()) != null;
    }

    public List<BoardGame> listAll() {
        return byId.values().stream()
                .sorted(Comparator.comparing(BoardGame::getName))
                .collect(Collectors.toList());
    }

    public int size() { return byId.size(); }
}

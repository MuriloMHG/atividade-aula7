package br.edu.ads1231;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class BoardGameCatalogTest {

    @Test
    void add_and_findById() {
        BoardGameCatalog cat = new BoardGameCatalog();
        BoardGame catan = new BoardGame("CATAN-1995", "Catan", 3, 4, 1995, "Kosmos");
        cat.add(catan);

        Assertions.assertEquals(1, cat.size());
        Assertions.assertTrue(cat.findById("catan-1995").isPresent());
    }

    @Test
    void add_duplicated_id_throws() {
        BoardGameCatalog cat = new BoardGameCatalog();
        cat.add(new BoardGame("X", "A", 2, 4, 2000, null));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                cat.add(new BoardGame("x", "B", 2, 4, 2001, null)));
    }

    @Test
    void searchByName_is_case_insensitive_and_sorted() {
        BoardGameCatalog cat = new BoardGameCatalog();
        cat.add(new BoardGame("1", "Azul", 2, 4, 2017, "Plan B"));
        cat.add(new BoardGame("2", "Catan", 3, 4, 1995, "Kosmos"));
        cat.add(new BoardGame("3", "CAThedral", 2, 2, 1978, "Ancient"));

        List<BoardGame> res = cat.searchByName("cat");
        Assertions.assertEquals(2, res.size());
        Assertions.assertEquals("CAThedral", res.get(0).getName());
        Assertions.assertEquals("Catan", res.get(1).getName());
    }

    @Test
    void remove_and_listAll() {
        BoardGameCatalog cat = new BoardGameCatalog();
        cat.add(new BoardGame("A1", "Azul", 2, 4, 2017, "Plan B"));
        cat.add(new BoardGame("C1", "Catan", 3, 4, 1995, "Kosmos"));

        Assertions.assertTrue(cat.remove("a1"));
        Assertions.assertEquals(1, cat.listAll().size());
    }
}

package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class PlayerTest {

    @Test
    public void shouldInstallOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game);
        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldInstallTwoGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн-2", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        assertTrue(store.containsGame(game1) && store.containsGame(game2));
    }


    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн-2", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.play(game1, 3);
        player.play(game2, 5);
        int expected = 8;
        int actual = player.sumGenre(game1.getGenre()) + player.sumGenre(game2.getGenre());
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldFindMostPlayerByExistGenreGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн-2", "Аркады");
        Game game3 = store.publishGame("Нетология Баттл Онлайн-3", "Аркады");
        Game game4 = store.publishGame("Нетология Баттл Онлайн-4", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.play(game1, 3);
        player.play(game2, 5);
        player.play(game3, 8);
        player.play(game4, 1);

        Assertions.assertEquals(game3, player.mostPlayerByGenre("Аркады"));
    }

    @Test
    public void shouldFindMostPlayerByNotExistGenreGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн-2", "Аркады");
        Game game3 = store.publishGame("Нетология Баттл Онлайн-3", "Аркады");
        Game game4 = store.publishGame("Нетология Баттл Онлайн-4", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.play(game1, 3);
        player.play(game2, 5);
        player.play(game3, 8);
        player.play(game4, 1);

        Assertions.assertEquals(null, player.mostPlayerByGenre("Бродилка"));
    }


}
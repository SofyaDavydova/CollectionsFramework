import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GameTest {

    Player player1 = new Player(1, "Света", 7);
    Player player2 = new Player(2, "Катя", 3);
    Player player3 = new Player(3, "Дима", 8);
    Player player4 = new Player(4, "Юра", 10);
    Player player5 = new Player(5, "Миша", 9);
    Player player6 = new Player(6, "Тамара", 4);
    Player player7 = new Player(7, "Соня", 7);
    Player player8 = new Player(8, "Виталик", 6);
    Player player9 = new Player(9, "Данил", 8);
    Player player10 = new Player(10, "Юля", 5);

    //тест registered
    @Test
    public void ShouldRegister() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);
        game.register(player5);
        game.register(player7);
        game.register(player9);

        HashMap<String, Player> registered = game.findAll();
        Player[] actual = {registered.get("Света"), registered.get("Дима"), registered.get("Миша"), registered.get("Соня"), registered.get("Данил")};
        Player[] expected = {player1, player3, player5, player7, player9};
        Assertions.assertArrayEquals(expected, actual);
    }

    //тесты findByName
    @Test
    public void ShouldFindByName() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.register(player9);
        game.register(player9);
        game.register(player10);

        Assertions.assertEquals(player2, game.findByName("Катя"));
    }

    @Test
    public void ShouldNotFindByName() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.register(player9);
        game.register(player9);
        game.register(player10);

        Assertions.assertEquals(null, game.findByName("Илья"));
    }

    //тесты round

    @Test
    public void ShouldTrowsExceptionFirstPlayerIsNotRegistered() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);
        game.register(player5);
        game.register(player7);
        game.register(player9);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Катя", "Света");
        });
    }

    @Test
    public void ShouldTrowsExceptionSecondPlayerIsNotRegistered() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);
        game.register(player5);
        game.register(player7);
        game.register(player9);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Миша", "Тамара");
        });
    }

    @Test
    public void ShouldFirstWinsSecond() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);
        game.register(player5);
        game.register(player7);
        game.register(player9);

        Assertions.assertEquals(1, game.round("Миша", "Света"));
    }

    @Test
    public void ShouldSecondWinsFirst() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);
        game.register(player5);
        game.register(player7);
        game.register(player9);

        Assertions.assertEquals(2, game.round("Соня", "Дима"));
    }

    @Test
    public void ShouldBeDraw() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);
        game.register(player5);
        game.register(player7);
        game.register(player9);

        Assertions.assertEquals(0, game.round("Дима", "Данил"));
    }
}

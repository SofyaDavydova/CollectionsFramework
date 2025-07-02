import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.name, player);
    }

    public Player findByName(String name) {
        if (players.containsKey(name)) {
            return players.get(name);
        }
        return null;
    }

    public HashMap<String, Player> findAll() {
        return players;
    }

    public int round(String playerName1, String playerName2) {

        if (!players.containsKey(playerName1)) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован!"
            );
        } else if (!players.containsKey(playerName2)) {
            throw new NotRegisteredException(
                    "Игрок " + playerName2 + " не зарегистрирован!"
            );
        } else {
            int strength1 = findByName(playerName1).getStrength();
            int strength2 = findByName(playerName2).getStrength();
            if (strength1 > strength2) {
                return 1;
            } else if (strength2 > strength1) {
                return 2;
            } else {
                return 0;
            }
        }
    }


}

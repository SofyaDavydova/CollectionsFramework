import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public ArrayList<Player> findAll() {
        return players;
    }

    public int round(String playerName1, String playerName2) {

        if (!players.contains(findByName(playerName1))) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован!"
            );
        } else if (!players.contains(findByName(playerName2))) {
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

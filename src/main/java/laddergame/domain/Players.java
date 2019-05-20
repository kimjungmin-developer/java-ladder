package laddergame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Players {
    List<Player> players = new ArrayList<>();

    public Players(String playersNames) {
        PlayerNamesValidator.checkNullName(playersNames);
        playersNames = playersNames.replaceAll(" ","");
        PlayerNamesValidator.checkConditions(playersNames);

        List<String> names = new ArrayList<>(Arrays.asList(playersNames.split(",")));
        for (String name : names) {
            players.add(new Player(name));
        }
    }

    public int getPeopleCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}

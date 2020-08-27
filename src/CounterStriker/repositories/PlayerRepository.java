package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository implements Repository<Player> {
    private Collection<Player> players;

    public PlayerRepository() {
        this.players = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return Collections.unmodifiableCollection(this.players);
    }

    @Override
    public void add(Player model) {
        if(model == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        this.players.add(model);
    }

    @Override
    public boolean remove(Player model) {
        for (Player player : players) {
            if (player == model) {
                this.players.remove(model);
                return true;
            }
        }
        return false;
    }

    @Override
    public Player findByName(String name) {
        for (Player player : players) {
            if(player.getUsername().equals(name)) {
                return player;
            }
        }
        return null;
    }
}

package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        if (type.equals("Pistol")) {
            this.guns.add(new Pistol(name, bulletsCount));
        } else if (type.equals("Rifle")) {
            this.guns.add(new Rifle(name, bulletsCount));
        } else {
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = guns.findByName(gunName);
        if (gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        if (type.equals("Terrorist")) {
            this.players.add(new Terrorist(username, health, armor, gun));
        } else if (type.equals("CounterTerrorist")) {
            this.players.add(new CounterTerrorist(username, health, armor, gun));
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        Collection<Player> players = this.players.getModels();

        return this.field.start(players);
    }

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();

        this.players.getModels().stream()
                .filter(player -> player instanceof CounterTerrorist)
                .sorted(Comparator.comparing(Player::getUsername))
                .forEach(player -> stringBuilder.append(player.toString()));

        this.players.getModels().stream()
                .filter(player -> player instanceof Terrorist)
                .sorted(Comparator.comparing(Player::getUsername))
                .forEach(player -> stringBuilder.append(player.toString()));
        
        return stringBuilder.toString().trim();
    }
}

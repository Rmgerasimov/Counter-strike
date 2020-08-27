package CounterStriker.models.field;

import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static CounterStriker.common.OutputMessages.*;

public class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = new ArrayList<>();
        List<Player> counterTerrorists = new ArrayList<>();

        for (Player player : players) {
            if (player instanceof Terrorist) {
                terrorists.add(player);
            } else {
                counterTerrorists.add(player);
            }
        }

        while (terrorists.size() != 0 && counterTerrorists.size() != 0) {
            for (Player terrorist : terrorists) {
                for (int i = 0; i < counterTerrorists.size(); ) {
                    int fire = terrorist.getGun().fire();

                    counterTerrorists.get(i).takeDamage(fire);
                    if (!counterTerrorists.get(i).isAlive()) {
                        counterTerrorists.remove(counterTerrorists.get(i));
                    } else {
                        i++;
                    }
                }
            }

            for (Player counterTerrorist : counterTerrorists) {
                for (int i = 0; i < terrorists.size(); ) {
                    int fire = counterTerrorist.getGun().fire();

                    terrorists.get(i).takeDamage(fire);
                    if (!terrorists.get(i).isAlive()) {
                        terrorists.remove(terrorists.get(i));
                    } else {
                        i++;
                    }
                }
            }
        }

        if (terrorists.size() == 0) {
            return COUNTER_TERRORIST_WINS;
        } else {
            return TERRORIST_WINS;
        }
    }
}

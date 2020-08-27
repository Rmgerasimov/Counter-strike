package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static CounterStriker.common.ExceptionMessages.*;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        for (Gun gun : models) {
            if (gun == model) {
                this.models.remove(model);
                return true;
            }
        }
        return false;
    }

    @Override
    public Gun findByName(String name) {
        for (Gun gun : models) {
            if (gun.getName().equals(name)) {
                return gun;
            }
        }
        return null;
    }
}

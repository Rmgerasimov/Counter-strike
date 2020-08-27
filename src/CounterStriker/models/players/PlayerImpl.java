package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
        this.setAlive(true);
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    private void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    @Override
    public void takeDamage(int points) {
        int currArmor = this.getArmor() - points;

        if (currArmor < 0) {
            this.setArmor(0);
            int damage = Math.abs(currArmor);

            if (this.getHealth() - damage <= 0) {
                this.setHealth(0);
            } else {
                this.setHealth(this.getHealth() - damage);
            }
        } else {
            this.setArmor(currArmor);
        }

        if (this.getHealth() <= 0) {
            this.setAlive(false);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.format("%s: %s", getClass().getSimpleName(), getUsername()))
                .append(System.lineSeparator());

        stringBuilder.append(String.format("--Health: %d", getHealth())).append(System.lineSeparator());
        stringBuilder.append(String.format("--Armor: %d", getArmor())).append(System.lineSeparator());
        stringBuilder.append(String.format("--Gun: %s", getGun().getName())).append(System.lineSeparator());

        return stringBuilder.toString();
    }
}

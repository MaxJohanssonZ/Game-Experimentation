package Game.Profile;

import Game.Gear.Armor;
import Game.Gear.Potion;
import Game.Gear.Weapon;

import java.util.Stack;

public class Character {
    int characterID;
    String charName;
    double damageDone;
    int health;
    Stack<Weapon> weapons = new Stack<>();
    Stack<Armor> armors = new Stack<>();
    Stack<Potion> potions = new Stack<>();

    public Character(String charName, double damageDone, int health) {
        this.charName = charName;
        this.damageDone = damageDone;
        this.health = health;
    }

    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public String getCharFirstName() {
        return charName;
    }

    public void setCharFirstName(String charFirstName) {
        this.charName = charFirstName;
    }

    public double getDamageDone() {
        return damageDone;
    }

    public void setDamageDone(double damageDone) {
        this.damageDone = damageDone;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Stack<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(Stack<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Stack<Armor> getArmors() {
        return armors;
    }

    public void setArmors(Stack<Armor> armors) {
        this.armors = armors;
    }

    public Stack<Potion> getPotions() {
        return potions;
    }

    public void setPotions(Stack<Potion> potions) {
        this.potions = potions;
    }
}

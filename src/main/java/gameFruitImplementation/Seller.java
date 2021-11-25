package gameFruitImplementation;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Seller class.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Seller extends Customer {
    // instance variables - replace the example below with your own
    private String nomVendeur;

    ArrayList<Fruit> fruits = new ArrayList<Fruit>();

    private Fruit fruit1;

    public Seller() {
    }

    public Collection<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    public Fruit getFruit() {
        // put your code here
        return this.fruit1;
    }

    /**
     * Constructor for objects of class Vendeur
     */
    public boolean addFruit(Fruit f) {
        this.fruits.add(f);
        if (this.fruits.contains(f)) {
            return true;
        } else
            return false;
    }

    public String getName() {
        // put your code here
        return this.nomVendeur;
    }

    public void setName(String s) {
        // put your code here
        this.nomVendeur = s;
    }

    public void setFruit(Fruit f1) {
        // put your code here
        this.fruit1 = f1;
    }

    public boolean fruitVendu(Fruit fruit2) {
        if (this.fruits.contains(fruit2)) {
            if (this.fruits.remove(fruit2))
                return true;
        }
        return false;
    }

    @Override
    public String getProfession() {
        return "Seller";
    }

    @Override
    public boolean goToGame() {
        return false;
    }

    @Override
    public boolean goToFruit() {
        return true;
    }
}

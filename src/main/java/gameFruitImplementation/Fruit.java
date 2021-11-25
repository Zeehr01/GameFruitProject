package gameFruitImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fruit implements StoreItems {
	// instance variables - replace the example below with your own
	private String name;
	private int price;
	private int quantite;
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	//creation of an attribute vendeur
	private Seller vendeur1;
	
	/**
	 * Constructor for objects of class Fruit
	 */
	public Fruit(String n, int p) {
		// initialise instance variables
		this.name = n;
		this.price = p;
	}
	public Fruit(String name) {
		// initialise instance variables
		this.name = name;
	}
	public Fruit() {
		// initialise instance variables
		this.name = "";
		this.price = 0;
		this.quantite=0;
	}
	/**
	 * An example of a method - replace this comment with your own
	 *
	 * @param y a sample parameter for a method
	 * @return the sum of x and y
	 */
	public String getName() {
		// put your code here
		return this.name;
	}

	public int getPrice() {
		// put your code here
		return this.price;
	}

	public void setName(String s) {
		// put your code here
		this.name = s;
	}

	public void setPrice(int p) {
		// put your code here
		this.price = p;
	}

	// Methode return le nom fruit avec le prix le moins cher
	public String pasCher() {
		if (this.price < 10) {

			return "pas cher";
		} else
			return "trop cher";

	}
	
	
	
	public List<String> getFruitList(){
		List<String> fruitsList=new ArrayList<String>();
		fruitsList.add("banana");
		fruitsList.add("Orange");
		fruitsList.add("pomme");
		
		return fruitsList;
	}
	public Map<String, Integer> getFruitMap(){
	Map<String, Integer> dictionary = new HashMap<String, Integer>();
	dictionary.put("banane", 3);
	dictionary.put("Orange", 3);
	dictionary.put("Pomme", 2);
	dictionary.put("Ananas", 5);
	dictionary.put("Kiwi", 5);
	dictionary.put("kaki", 7);
	dictionary.put("Citron", 2);
	return dictionary;
	}
	public String searchFruit(Fruit fruit) {
		if(fruit.getFruitMap().containsKey(fruit.getName())) {
			if(getFruitMap().get(fruit.getName())==fruit.getPrice()) {
				return fruit.getName();
			}
		
		}
		return null;
	}

	public Map<String, Integer> getFruitQuantityMap() {
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		dictionary.put("banane", 0);
		dictionary.put("Orange", 13);
		dictionary.put("Pomme", 12);
		dictionary.put("Ananas", 15);
		dictionary.put("Kiwi", 0);
		dictionary.put("kaki", 0);
		dictionary.put("Citron", 14);
		return dictionary;
	}

	public List<String> getNonDispoFruits() {
		List<String> fruitsnondispo = new ArrayList<String>();
		Map<String, Integer> map = this.getFruitQuantityMap();

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 0) {
				fruitsnondispo.add(entry.getKey());

			}

		}
		return fruitsnondispo;
	}

  @Override
  public boolean buy(String name, int price) {
    Fruit fruit = new Fruit();
    if (fruit.getFruitMap().containsKey(name)) {
      if (getFruitMap().get(name) <= price) {
        return true;
      }
    }
    return false;
  }
}

package gameFruitImplementation;

public class StoreItemsFactory {
    public static StoreItems getPreferedItems(String citeria){

        if(citeria=="geek") {

            return new Game();
        }
        else if (citeria=="baker"){

            return new Fruit();
        }
        else return null;
    }

}

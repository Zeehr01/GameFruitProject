package gameFruitImplementation;

public abstract class Customer {

    public abstract String getProfession();

    public abstract boolean goToGame();

    public abstract boolean goToFruit();

    public final void purchaser() {
        getProfession();
        goToGame();
        goToFruit();
    }
}

public class Joueur {

    public static String pseudo;
    private int serveur;
    private Salon salon;

    public Joueur(String pseudo, int serveur) {
        this.pseudo = pseudo;
        this.serveur = serveur;
    }

    public static String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getServeur() {
        return serveur;
    }

    public void setServeur(int serveur) {
        this.serveur = serveur;
    }
}

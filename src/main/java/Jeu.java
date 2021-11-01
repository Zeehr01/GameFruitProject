public class Jeu {
    public static String nom;
    private int niveau;
    private int evolution;
    private Salon salon;

    public Jeu(int niveau, int evolution, String nom) {
        this.niveau = niveau;
        this.evolution = evolution;
        this.nom = nom;
    }

    public int getNiveau() {

        return this.niveau;
    }

    public void setNiveau(int niveau) {

        this.niveau = niveau;
    }

    public int getEvolution() {

        return this.evolution;
    }

    public void setEvolution(int evolution) {

        this.evolution = evolution;
    }

    public int niveauFinal() {

        return this.niveau + this.evolution;
    }

    /*public Salon getSalon() {

        return salon;
    }
    public void setSalon(Salon salon) {

        this.salon = salon;
    }*/
    public String getNom() {

        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

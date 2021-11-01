import java.util.ArrayList;

public class Salon {
    //private String s="test";
    public static ArrayList<Jeu> jeux;
    public static ArrayList<Joueur> joueurs;
    public static String nomSalon;
    public static int k = 0;
    /**
     * Décrivez votre classe Salon ici.
     *
     * @author (Hajar Lamhandy, Litissia Ait Akli)
     * @version (25 octobre 2021)
     */

    private int i;

    public Salon(String nomSalon) {
        this.nomSalon = nomSalon;
    }

    public Salon(ArrayList<Jeu> jeux, ArrayList<Joueur> joueurs) {
        this.jeux = jeux;
        this.joueurs = joueurs;
    }

    public static int getNbParties() {

        return jeux.size();
    }

    public static void ajouterJeu(Jeu jeu) {
        // Si le jeu est disponible sur la plateforme, on ajoute le jeu dans le salon
        if ((k < 10)) {
            Plateforme.jeux_de_plateforme(jeu.getNom());
            if (jeu.getNom() == Plateforme.jeux_de_plateforme(jeu.getNom())) {
                jeux.add(jeu);
                System.out.println("Le jeu " + jeu.getNom() + " est dans la plateforme et il est ajouté dans le salon");
            }
            k++;
        }
    }

    public static int affiche_nbrejoueur() {

        System.out.println("Vous avez " + jeux.size() + " dans le salon");
        return jeux.size();
    }

    public String getNomSalon() {
        return nomSalon;
    }

    public void setNomSalon() {
        this.nomSalon = nomSalon;
    }

    public ArrayList<Jeu> getJeux() {
        return jeux;
    }

    public void setJeux(ArrayList<Jeu> jeux) {
        this.jeux = jeux;
    }

    public void supprimerJeu(Jeu jeu) {
        if (jeux.size() > 1) {
            jeux.remove(jeu);
            System.out.println("Le jeu " + jeu.getNom() + " est supprimé ");
        } else {
            System.out.println("Vous ne pouvez pas supprimer ce jeu, car vous avez un seul jeu dans ce salon :(");
        }
    }

    public void addJoueur(Joueur joueur) {
        Plateforme.joueurs_de_plateforme(joueur.getPseudo());
        if (joueurs.size() < 20) {
            //for (String n : Plateforme.joueursPlateforme)
            //  if (joueur.getPseudo() == n) {
            joueurs.add(joueur);
            // }

            System.out.println(
                    "Le joueur "
                            + joueur.getPseudo()
                            + " est ajouté dans le salon. Vous avez actuellement " + joueurs.size() + " joueurs");
        }

    }

    public void removeJoueur(Joueur joueur) {
        if (joueurs.size() > 1) {
            joueurs.remove(joueur);
            System.out.println("Le joueur " + joueur.getPseudo() + " est supprimé ");
        }
    }
}

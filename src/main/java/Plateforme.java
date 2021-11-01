import java.awt.*;
import java.util.ArrayList;

public class Plateforme {
    public static ArrayList<String> salon;
    public static ArrayList<String> jeuxPlateforme;
    public static ArrayList<String> joueursPlateforme;
    public static String n;
    private int nbr_Salon = 0;

    public Plateforme(ArrayList<String> jeuxPlateforme, ArrayList<String> salon, ArrayList<String> joueursPlateforme) {
        this.jeuxPlateforme = jeuxPlateforme;
        this.joueursPlateforme = joueursPlateforme;
        this.salon = salon;
    }

    public static String jeux_de_plateforme(String n) {
        //for (int i=0; i<10; i++)
        //jeuxPlateforme.add(i,n);
        return n;

        //return null;
    }

    public static void joueurs_de_plateforme(String s) {

        joueursPlateforme.add(Joueur.pseudo);

    }

    public void ajouterSalon(Salon s) { //Créer un salon, uniquement si le nombre de salon est inférieur à 10/
        if (nbr_Salon < 10) {
            salon.add(s.nomSalon);
            nbr_Salon++;
            System.out.println("Votre salon " + s.getNomSalon() + "est bien ajouté sur la plateforme");
        }
    }

    /*public static int affiche_nbrejoueur(){

        System.out.println("Vous avez "+ Salon.jeux.size()+ " dans le salon");
        return jeuxPlateforme.size();
    }*/
    public void supprimerSalon(Salon s) {
        //if(nbr_Salon>1){
        salon.remove(s.nomSalon);
        nbr_Salon--;
        System.out.println("Le salon " + s.getNomSalon() + " est supprimé de la plateforme");
        // }
    }
}

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;

public class jeuRunner {
    ArrayList<String> jp = new ArrayList<>();
    ArrayList<String> jr = new ArrayList<>();
    ArrayList<String> salon = new ArrayList<>();
    Plateforme p = new Plateforme(jp, salon, jr);
    ArrayList<Joueur> joueurs = new ArrayList<>();
    private Jeu jeu;
    private Jeu jeu_2;
    private Salon s;
    private Joueur joueur;
    private ArrayList<Jeu> j = new ArrayList<>();
    Salon s1 = new Salon(j, joueurs);

    @Given("un jeu")
    public void unJeu() {

        jeu = new Jeu(1, 3, "Mario");

    }

    @When("l'utilisateur ajoute le jeu dans le salon") //US 01 du lot 1
    public void lUtilisateurAjouteLeJeuDansLeSalon() {
        s1.ajouterJeu(jeu);
    }

    @Then("le jeu apparait dans la liste")
    public void leJeuApparaitDansLaListe() {
        for (int i = 0; i < p.jeuxPlateforme.size(); i++) {
            Assert.assertEquals("Mario", p.jeuxPlateforme.get(i));
        }

    }


   /* @And("le nombre de jeux est augmenté")
    public void leNombreDeJeuxEstAugmenté() {
        Assert.assertEquals(p.affiche_nbrejoueur(), 1);
    }*/

    @Given("un autre jeu")
    public void unAutreJeu() {
        jeu_2 = new Jeu(2, 4, "SSSS");
    }

    @When("l'utilisateur ajoute un autre le jeu dans le salon")
    public void lUtilisateurAjouteUnAutreLeJeuDansLeSalon() {


        s1.ajouterJeu(jeu_2);


    }

    @Then("le jeu apparait dans la liste des jeux du salon")
    public void leJeuApparaitDansLaListeDesJeuxDuSalon() {
        for (int i = 0; i < p.jeuxPlateforme.size(); i++) {
            Assert.assertEquals("SSSS", p.jeuxPlateforme.get(i));
        }
    }
   /* @And("le nombre de jeux augmente")
    public void leNombreDeJeuxAugmente() {

            Assert.assertEquals(s1.affiche_nbrejoueur(), 1);

    }*/


    @When("l'utilisateur supprime un jeu dans le salon") // US 2 du lot 1
    public void lUtilisateurSupprimeUnJeuDansLeSalon() {
        s1.supprimerJeu(jeu);
    }

    @Then("le jeu n'apparaît pas dans le salon")
    public void leJeuNApparaîtPasDansLeSalon() {

        for (String n : p.jeuxPlateforme) {
            Assert.assertNotEquals("Mario", n);
        }
    }

   /* @And("le nombre de jeux diminue")
    public void leNombreDeJeuxDiminue() {
        Assert.assertEquals(s1.affiche_nbrejoueur(), 1);
    }*/

    @Given("un salon")
    public void unSalon() {
        s = new Salon("Salon_CowBoy");
    }

    @When("l'utilisateur ajoute un salon de jeu")
    public void lUtilisateurAjouteUnSalonDeJeu() {
        p.ajouterSalon(s);
    }

    @Then("le salon est ajouté à la liste des salons")
    public void leSalonEstAjoutéÀLaListeDesSalons() {
        for (String a : p.salon) {
            Assert.assertEquals("Salon_CowBoy", a);
        }
    }

    @When("l'utilisateur supprime un salon de jeu")
    public void lUtilisateurSupprimeUnSalonDeJeu() {
        p.supprimerSalon(s);
    }

    @Then("le salon sera supprimé de la liste de la plateforme")
    public void leSalonSeraSuppriméDeLaListeDeLaPlateforme() {
        for (String b : p.salon)
            Assert.assertNotEquals(b, "Salon_CowBoy");

    }

    @Given("un joueur")
    public void unJoueur() {
        joueur = new Joueur("Alex", 5);
    }

    @When("l'utilisateur ajouter un joueur dans un salon")
    public void lUtilisateurAjouterUnJoueurDansUnSalon() {
        // for (int k=0; k<=21; k++) {
        s1.addJoueur(joueur);
        // }
    }

    @Then("le joueur est ajouté dans le salon")
    public void leJoueurEstAjoutéDansLeSalon() {
        for (String c : p.joueursPlateforme) {
            Assert.assertEquals(c, "Alex");
        }
    }

    @When("l'utilisateur supprime un joueur")
    public void lUtilisateurSupprimeUnJoueur() {
        s1.removeJoueur(joueur);
    }

    @Then("le joueur est retiré de la liste")
    public void leJoueurEstRetiréDeLaListe() {
        for (Joueur d : s1.joueurs) {
            Assert.assertEquals(d, joueur);
        }
    }

}
// Classe représentant un compte bancaire
class Compte {
    private double solde;
    private double tauxInteret;

    public Compte(double solde, double tauxInteret) {
        this.solde = solde;
        this.tauxInteret = tauxInteret;
    }

    // Méthode pour appliquer l'intérêt et mettre à jour le solde
    public void appliquerInteret() {
        solde += solde * tauxInteret;
    }

    // Getter pour obtenir le solde
    public double getSolde() {
        return solde;
    }

    @Override
    public String toString() {
        return String.format("%.1f francs", solde);
    }
}

// Classe représentant un client de la banque
class Client {
    private String nom;
    private String ville;
    private Compte comptePrive;
    private Compte compteEpargne;

    public Client(String nom, String ville, double soldePrive, double soldeEpargne, double tauxPrive, double tauxEpargne) {
        this.nom = nom;
        this.ville = ville;
        this.comptePrive = new Compte(soldePrive, tauxPrive);
        this.compteEpargne = new Compte(soldeEpargne, tauxEpargne);
    }

    // Méthode pour appliquer les intérêts aux deux comptes du client
    public void bouclerComptes() {
        comptePrive.appliquerInteret();
        compteEpargne.appliquerInteret();
    }

    // Méthode pour afficher les informations du client et de ses comptes
    public void afficherInfos() {
        System.out.println("Client " + nom + " de " + ville);
        System.out.println("Compte prive: " + comptePrive);
        System.out.println("Compte d'epargne: " + compteEpargne);
    }
}

// Classe principale représentant la banque
public class Banque2 {
    public static void main(String[] args) {
        // Taux d'intérêt pour les comptes privés et d'épargne
        double tauxPrive = 0.01;
        double tauxEpargne = 0.02;

        // Création des deux clients
        Client client1 = new Client("Pedro", "Geneve", 1000.0, 2000.0, tauxPrive, tauxEpargne);
        Client client2 = new Client("Alexandra", "Lausanne", 3000.0, 4000.0, tauxPrive, tauxEpargne);

        // Affichage des données avant le bouclement des comptes
        System.out.println("Donnees avant le bouclement des comptes:");
        client1.afficherInfos();
        client2.afficherInfos();

        // Bouclage des comptes pour appliquer les intérêts
        client1.bouclerComptes();
        client2.bouclerComptes();

        // Affichage des données après le bouclement des comptes
        System.out.println("\nDonnees apres le bouclement des comptes:");
        client1.afficherInfos();
        client2.afficherInfos();
    }
}

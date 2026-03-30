import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SalleSport salleSport = new SalleSport();

    public static void main(String[] args) {
        salleSport.chargerDonneesExemple();
        lancerApplication();
    }

    private static void lancerApplication() {
        int choix;
        do {
            afficherMenuPrincipal();
            choix = lireEntier("Votre choix : ");

            switch (choix) {
                case 1 -> gererAdherents();
                case 2 -> gererActivites();
                case 3 -> gererInscriptions();
                case 4 -> afficherConsultations();
                case 5 -> afficherFonctionnalitesAvancees();
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private static void afficherMenuPrincipal() {
        System.out.println("\n===== GESTION D'UNE SALLE DE SPORT =====");
        System.out.println("1. Gestion des adhérents");
        System.out.println("2. Gestion des activités");
        System.out.println("3. Gestion des inscriptions");
        System.out.println("4. Affichage et consultation");
        System.out.println("5. Fonctionnalités avancées");
        System.out.println("0. Quitter");
    }

    private static void gererAdherents() {
        int choix;
        do {
            System.out.println("\n--- Gestion des adhérents ---");
            System.out.println("1. Ajouter un adhérent");
            System.out.println("2. Supprimer un adhérent");
            System.out.println("3. Modifier un adhérent");
            System.out.println("4. Afficher les adhérents");
            System.out.println("5. Rechercher un adhérent par ID");
            System.out.println("6. Rechercher un adhérent par nom/prénom");
            System.out.println("0. Retour");

            choix = lireEntier("Votre choix : ");
            switch (choix) {
                case 1 -> ajouterAdherent();
                case 2 -> supprimerAdherent();
                case 3 -> modifierAdherent();
                case 4 -> afficherListeAdherents(salleSport.getListeAdherents());
                case 5 -> rechercherAdherentParId();
                case 6 -> rechercherAdherentParNom();
                case 0 -> {
                }
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private static void gererActivites() {
        int choix;
        do {
            System.out.println("\n--- Gestion des activités ---");
            System.out.println("1. Ajouter une activité");
            System.out.println("2. Supprimer une activité");
            System.out.println("3. Modifier une activité");
            System.out.println("4. Afficher les activités");
            System.out.println("5. Rechercher une activité par ID");
            System.out.println("6. Rechercher une activité par nom");
            System.out.println("0. Retour");

            choix = lireEntier("Votre choix : ");
            switch (choix) {
                case 1 -> ajouterActivite();
                case 2 -> supprimerActivite();
                case 3 -> modifierActivite();
                case 4 -> afficherListeActivites(salleSport.getListeActivites());
                case 5 -> rechercherActiviteParId();
                case 6 -> rechercherActiviteParNom();
                case 0 -> {
                }
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private static void gererInscriptions() {
        int choix;
        do {
            System.out.println("\n--- Gestion des inscriptions ---");
            System.out.println("1. Inscrire un adhérent à une activité");
            System.out.println("2. Annuler une inscription");
            System.out.println("3. Afficher les adhérents inscrits à une activité");
            System.out.println("4. Afficher les activités d'un adhérent");
            System.out.println("0. Retour");

            choix = lireEntier("Votre choix : ");
            switch (choix) {
                case 1 -> inscrireAdherent();
                case 2 -> annulerInscription();
                case 3 -> afficherAdherentsInscritsAUneActivite();
                case 4 -> afficherActivitesDUnAdherent();
                case 0 -> {
                }
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private static void afficherConsultations() {
        int choix;
        do {
            System.out.println("\n--- Affichage et consultation ---");
            System.out.println("1. Afficher tous les adhérents");
            System.out.println("2. Afficher toutes les activités");
            System.out.println("3. Afficher les activités complètes");
            System.out.println("4. Afficher les activités disponibles");
            System.out.println("5. Afficher les inscriptions en cours");
            System.out.println("0. Retour");

            choix = lireEntier("Votre choix : ");
            switch (choix) {
                case 1 -> afficherListeAdherents(salleSport.getListeAdherents());
                case 2 -> afficherListeActivites(salleSport.getListeActivites());
                case 3 -> afficherListeActivites(salleSport.getActivitesCompletes());
                case 4 -> afficherListeActivites(salleSport.getActivitesDisponibles());
                case 5 -> afficherListeInscriptions(salleSport.getInscriptionsEnCours());
                case 0 -> {
                }
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private static void afficherFonctionnalitesAvancees() {
        int choix;
        do {
            System.out.println("\n--- Fonctionnalités avancées ---");
            System.out.println("1. Trier les adhérents par nom");
            System.out.println("2. Trier les adhérents par âge");
            System.out.println("3. Trier les activités par nom");
            System.out.println("4. Trier les activités par horaire");
            System.out.println("5. Afficher l'activité la plus demandée");
            System.out.println("6. Afficher les statistiques d'inscription");
            System.out.println("7. Afficher la limite d'activités par adhérent");
            System.out.println("0. Retour");

            choix = lireEntier("Votre choix : ");
            switch (choix) {
                case 1 -> afficherListeAdherents(salleSport.trierAdherentsParNom());
                case 2 -> afficherListeAdherents(salleSport.trierAdherentsParAge());
                case 3 -> afficherListeActivites(salleSport.trierActivitesParNom());
                case 4 -> afficherListeActivites(salleSport.trierActivitesParHoraire());
                case 5 -> afficherActiviteLaPlusDemandee();
                case 6 -> afficherStatistiques();
                case 7 -> System.out.println("Un adhérent peut être inscrit au maximum à "
                        + salleSport.getLimiteActivitesParAdherent() + " activités actives.");
                case 0 -> {
                }
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private static void ajouterAdherent() {
        System.out.println("\nAjout d'un adhérent");
        int id = lireEntier("ID : ");
        String nom = lireTexte("Nom : ");
        String prenom = lireTexte("Prénom : ");
        int age = lireEntier("Âge : ");
        String telephone = lireTexte("Téléphone : ");
        String email = lireTexte("Email : ");

        boolean ajoute = salleSport.ajouterAdherent(new Adherent(id, nom, prenom, age, telephone, email));
        System.out.println(ajoute ? "Adhérent ajouté avec succès." : "Impossible : ID déjà utilisé.");
    }

    private static void supprimerAdherent() {
        int id = lireEntier("ID de l'adhérent à supprimer : ");
        boolean supprime = salleSport.supprimerAdherent(id);
        System.out.println(supprime ? "Adhérent supprimé." : "Adhérent introuvable.");
    }

    private static void modifierAdherent() {
        int id = lireEntier("ID de l'adhérent à modifier : ");
        if (salleSport.rechercherAdherentParId(id) == null) {
            System.out.println("Adhérent introuvable.");
            return;
        }

        String nom = lireTexte("Nouveau nom : ");
        String prenom = lireTexte("Nouveau prénom : ");
        int age = lireEntier("Nouvel âge : ");
        String telephone = lireTexte("Nouveau téléphone : ");
        String email = lireTexte("Nouvel email : ");

        boolean modifie = salleSport.modifierAdherent(id, nom, prenom, age, telephone, email);
        System.out.println(modifie ? "Adhérent modifié." : "Modification impossible.");
    }

    private static void rechercherAdherentParId() {
        int id = lireEntier("ID recherché : ");
        Adherent adherent = salleSport.rechercherAdherentParId(id);
        if (adherent == null) {
            System.out.println("Aucun adhérent trouvé.");
        } else {
            System.out.println(adherent.afficherDetails());
        }
    }

    private static void rechercherAdherentParNom() {
        String nom = lireTexte("Nom ou prénom recherché : ");
        List<Adherent> resultats = salleSport.rechercherAdherentParNom(nom);
        afficherListeAdherents(resultats);
    }

    private static void ajouterActivite() {
        System.out.println("\nAjout d'une activité");
        int id = lireEntier("ID : ");
        String nom = lireTexte("Nom de l'activité : ");
        String coach = lireTexte("Coach : ");
        int capacite = lireEntier("Capacité maximale : ");
        String horaire = lireTexte("Horaire : ");

        boolean ajoutee = salleSport.ajouterActivite(new Activite(id, nom, coach, capacite, horaire));
        System.out.println(ajoutee ? "Activité ajoutée avec succès." : "Impossible : ID déjà utilisé.");
    }

    private static void supprimerActivite() {
        int id = lireEntier("ID de l'activité à supprimer : ");
        boolean supprimee = salleSport.supprimerActivite(id);
        System.out.println(supprimee ? "Activité supprimée." : "Activité introuvable.");
    }

    private static void modifierActivite() {
        int id = lireEntier("ID de l'activité à modifier : ");
        if (salleSport.rechercherActiviteParId(id) == null) {
            System.out.println("Activité introuvable.");
            return;
        }

        String nom = lireTexte("Nouveau nom : ");
        String coach = lireTexte("Nouveau coach : ");
        int capacite = lireEntier("Nouvelle capacité : ");
        String horaire = lireTexte("Nouvel horaire : ");

        boolean modifiee = salleSport.modifierActivite(id, nom, coach, capacite, horaire);
        System.out.println(modifiee ? "Activité modifiée." : "Modification impossible.");
    }

    private static void rechercherActiviteParId() {
        int id = lireEntier("ID recherché : ");
        Activite activite = salleSport.rechercherActiviteParId(id);
        if (activite == null) {
            System.out.println("Aucune activité trouvée.");
        } else {
            System.out.println(activite.afficherDetails());
        }
    }

    private static void rechercherActiviteParNom() {
        String nom = lireTexte("Nom recherché : ");
        List<Activite> resultats = salleSport.rechercherActiviteParNom(nom);
        afficherListeActivites(resultats);
    }

    private static void inscrireAdherent() {
        int idAdherent = lireEntier("ID de l'adhérent : ");
        int idActivite = lireEntier("ID de l'activité : ");
        System.out.println(salleSport.inscrireAdherent(idAdherent, idActivite));
    }

    private static void annulerInscription() {
        int idAdherent = lireEntier("ID de l'adhérent : ");
        int idActivite = lireEntier("ID de l'activité : ");
        boolean annulee = salleSport.annulerInscription(idAdherent, idActivite);
        System.out.println(annulee ? "Inscription annulée." : "Aucune inscription active trouvée.");
    }

    private static void afficherAdherentsInscritsAUneActivite() {
        int idActivite = lireEntier("ID de l'activité : ");
        List<Adherent> adherents = salleSport.getAdherentsInscritsActivite(idActivite);
        afficherListeAdherents(adherents);
    }

    private static void afficherActivitesDUnAdherent() {
        int idAdherent = lireEntier("ID de l'adhérent : ");
        List<Activite> activites = salleSport.getActivitesAdherent(idAdherent);
        afficherListeActivites(activites);
    }

    private static void afficherActiviteLaPlusDemandee() {
        Activite activite = salleSport.getActiviteLaPlusDemandee();
        if (activite == null) {
            System.out.println("Aucune activité disponible.");
            return;
        }
        int nb = salleSport.getNombreInscritsActifsPourActivite(activite.getId());
        System.out.println("Activité la plus demandée : " + activite + " | Inscrits actifs : " + nb);
    }

    private static void afficherStatistiques() {
        Map<String, Integer> stats = salleSport.getStatistiquesInscriptions();
        System.out.println("\n--- Statistiques ---");
        System.out.println("Nombre d'adhérents : " + stats.get("adherents"));
        System.out.println("Nombre d'activités : " + stats.get("activites"));
        System.out.println("Nombre d'inscriptions actives : " + stats.get("inscriptionsActives"));
        System.out.println("Activités complètes : " + stats.get("activitesCompletes"));
        System.out.println("Activités disponibles : " + stats.get("activitesDisponibles"));
        System.out.println("Adhérents inscrits (uniques) : " + stats.get("adherentsInscritsUniques"));
    }

    private static void afficherListeAdherents(List<Adherent> adherents) {
        if (adherents == null || adherents.isEmpty()) {
            System.out.println("Aucun adhérent à afficher.");
            return;
        }
        System.out.println("\nListe des adhérents :");
        for (Adherent adherent : adherents) {
            System.out.println("- " + adherent.afficherDetails());
        }
    }

    private static void afficherListeActivites(List<Activite> activites) {
        if (activites == null || activites.isEmpty()) {
            System.out.println("Aucune activité à afficher.");
            return;
        }
        System.out.println("\nListe des activités :");
        for (Activite activite : activites) {
            int nbInscrits = salleSport.getNombreInscritsActifsPourActivite(activite.getId());
            System.out.println("- " + activite.afficherDetails() + " | Inscrits actifs : " + nbInscrits);
        }
    }

    private static void afficherListeInscriptions(List<Inscription> inscriptions) {
        if (inscriptions == null || inscriptions.isEmpty()) {
            System.out.println("Aucune inscription à afficher.");
            return;
        }
        System.out.println("\nListe des inscriptions :");
        for (Inscription inscription : inscriptions) {
            System.out.println("- " + inscription.afficherInscription());
        }
    }

    private static int lireEntier(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre entier valide.");
            }
        }
    }

    private static String lireTexte(String message) {
        String valeur;
        do {
            System.out.print(message);
            valeur = scanner.nextLine().trim();
            if (valeur.isEmpty()) {
                System.out.println("La valeur ne peut pas être vide.");
            }
        } while (valeur.isEmpty());
        return valeur;
    }
}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalleSport {
    private ArrayList<Adherent> listeAdherents;
    private ArrayList<Activite> listeActivites;
    private ArrayList<Inscription> listeInscriptions;
    private int limiteActivitesParAdherent;

    public SalleSport() {
        this.listeAdherents = new ArrayList<>();
        this.listeActivites = new ArrayList<>();
        this.listeInscriptions = new ArrayList<>();
        this.limiteActivitesParAdherent = 3;
    }

    public ArrayList<Adherent> getListeAdherents() {
        return listeAdherents;
    }

    public ArrayList<Activite> getListeActivites() {
        return listeActivites;
    }

    public ArrayList<Inscription> getListeInscriptions() {
        return listeInscriptions;
    }

    public int getLimiteActivitesParAdherent() {
        return limiteActivitesParAdherent;
    }

    public void setLimiteActivitesParAdherent(int limiteActivitesParAdherent) {
        this.limiteActivitesParAdherent = limiteActivitesParAdherent;
    }

    public boolean ajouterAdherent(Adherent adherent) {
        if (rechercherAdherentParId(adherent.getId()) != null) {
            return false;
        }
        return listeAdherents.add(adherent);
    }

    public boolean supprimerAdherent(int idAdherent) {
        Adherent adherent = rechercherAdherentParId(idAdherent);
        if (adherent == null) {
            return false;
        }
        listeInscriptions.removeIf(inscription -> inscription.getAdherent().getId() == idAdherent);
        return listeAdherents.remove(adherent);
    }

    public boolean modifierAdherent(int idAdherent, String nom, String prenom, int age, String telephone, String email) {
        Adherent adherent = rechercherAdherentParId(idAdherent);
        if (adherent == null) {
            return false;
        }
        adherent.setNom(nom);
        adherent.setPrenom(prenom);
        adherent.setAge(age);
        adherent.setTelephone(telephone);
        adherent.setEmail(email);
        return true;
    }

    public Adherent rechercherAdherentParId(int idAdherent) {
        for (Adherent adherent : listeAdherents) {
            if (adherent.getId() == idAdherent) {
                return adherent;
            }
        }
        return null;
    }

    public List<Adherent> rechercherAdherentParNom(String nom) {
        return listeAdherents.stream()
                .filter(a -> a.getNom().equalsIgnoreCase(nom) || a.getPrenom().equalsIgnoreCase(nom))
                .collect(Collectors.toList());
    }

    public boolean ajouterActivite(Activite activite) {
        if (rechercherActiviteParId(activite.getId()) != null) {
            return false;
        }
        return listeActivites.add(activite);
    }

    public boolean supprimerActivite(int idActivite) {
        Activite activite = rechercherActiviteParId(idActivite);
        if (activite == null) {
            return false;
        }
        listeInscriptions.removeIf(inscription -> inscription.getActivite().getId() == idActivite);
        return listeActivites.remove(activite);
    }

    public boolean modifierActivite(int idActivite, String nom, String coach, int capacite, String horaire) {
        Activite activite = rechercherActiviteParId(idActivite);
        if (activite == null) {
            return false;
        }
        activite.setNomActivite(nom);
        activite.setCoach(coach);
        activite.setCapaciteMax(capacite);
        activite.setHoraire(horaire);
        return true;
    }

    public Activite rechercherActiviteParId(int idActivite) {
        for (Activite activite : listeActivites) {
            if (activite.getId() == idActivite) {
                return activite;
            }
        }
        return null;
    }

    public List<Activite> rechercherActiviteParNom(String nom) {
        return listeActivites.stream()
                .filter(a -> a.getNomActivite().equalsIgnoreCase(nom) || a.getNomActivite().toLowerCase().contains(nom.toLowerCase()))
                .collect(Collectors.toList());
    }

    public String inscrireAdherent(int idAdherent, int idActivite) {
        Adherent adherent = rechercherAdherentParId(idAdherent);
        if (adherent == null) {
            return "Adhérent introuvable.";
        }

        Activite activite = rechercherActiviteParId(idActivite);
        if (activite == null) {
            return "Activité introuvable.";
        }

        for (Inscription inscription : listeInscriptions) {
            if (inscription.getAdherent().getId() == idAdherent
                    && inscription.getActivite().getId() == idActivite
                    && inscription.estActive()) {
                return "Cet adhérent est déjà inscrit à cette activité.";
            }
        }

        if (getNombreActivitesActivesPourAdherent(idAdherent) >= limiteActivitesParAdherent) {
            return "Inscription refusée : limite de " + limiteActivitesParAdherent + " activités atteinte pour cet adhérent.";
        }

        if (activite.estComplete(getNombreInscritsActifsPourActivite(idActivite))) {
            return "Inscription refusée : l'activité est complète.";
        }

        listeInscriptions.add(new Inscription(adherent, activite, LocalDate.now()));
        return "Inscription enregistrée avec succès.";
    }

    public boolean annulerInscription(int idAdherent, int idActivite) {
        for (Inscription inscription : listeInscriptions) {
            if (inscription.getAdherent().getId() == idAdherent
                    && inscription.getActivite().getId() == idActivite
                    && inscription.estActive()) {
                inscription.annulerInscription();
                return true;
            }
        }
        return false;
    }

    public int getNombreInscritsActifsPourActivite(int idActivite) {
        int compteur = 0;
        for (Inscription inscription : listeInscriptions) {
            if (inscription.getActivite().getId() == idActivite && inscription.estActive()) {
                compteur++;
            }
        }
        return compteur;
    }

    public int getNombreActivitesActivesPourAdherent(int idAdherent) {
        int compteur = 0;
        for (Inscription inscription : listeInscriptions) {
            if (inscription.getAdherent().getId() == idAdherent && inscription.estActive()) {
                compteur++;
            }
        }
        return compteur;
    }

    public List<Adherent> getAdherentsInscritsActivite(int idActivite) {
        return listeInscriptions.stream()
                .filter(i -> i.getActivite().getId() == idActivite && i.estActive())
                .map(Inscription::getAdherent)
                .collect(Collectors.toList());
    }

    public List<Activite> getActivitesAdherent(int idAdherent) {
        return listeInscriptions.stream()
                .filter(i -> i.getAdherent().getId() == idAdherent && i.estActive())
                .map(Inscription::getActivite)
                .collect(Collectors.toList());
    }

    public List<Activite> getActivitesCompletes() {
        return listeActivites.stream()
                .filter(a -> a.estComplete(getNombreInscritsActifsPourActivite(a.getId())))
                .collect(Collectors.toList());
    }

    public List<Activite> getActivitesDisponibles() {
        return listeActivites.stream()
                .filter(a -> !a.estComplete(getNombreInscritsActifsPourActivite(a.getId())))
                .collect(Collectors.toList());
    }

    public List<Inscription> getInscriptionsEnCours() {
        return listeInscriptions.stream()
                .filter(Inscription::estActive)
                .collect(Collectors.toList());
    }

    public List<Adherent> trierAdherentsParNom() {
        return listeAdherents.stream()
                .sorted(Comparator.comparing(Adherent::getNom, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Adherent::getPrenom, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public List<Adherent> trierAdherentsParAge() {
        return listeAdherents.stream()
                .sorted(Comparator.comparingInt(Adherent::getAge))
                .collect(Collectors.toList());
    }

    public List<Activite> trierActivitesParNom() {
        return listeActivites.stream()
                .sorted(Comparator.comparing(Activite::getNomActivite, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public List<Activite> trierActivitesParHoraire() {
        return listeActivites.stream()
                .sorted(Comparator.comparing(Activite::getHoraire, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public int calculerNombreTotalAdherentsInscrits() {
        return (int) listeInscriptions.stream()
                .filter(Inscription::estActive)
                .map(i -> i.getAdherent().getId())
                .distinct()
                .count();
    }

    public Activite getActiviteLaPlusDemandee() {
        Activite activiteLaPlusDemandee = null;
        int max = -1;
        for (Activite activite : listeActivites) {
            int nb = getNombreInscritsActifsPourActivite(activite.getId());
            if (nb > max) {
                max = nb;
                activiteLaPlusDemandee = activite;
            }
        }
        return activiteLaPlusDemandee;
    }

    public Map<String, Integer> getStatistiquesInscriptions() {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("adherents", listeAdherents.size());
        stats.put("activites", listeActivites.size());
        stats.put("inscriptionsActives", getInscriptionsEnCours().size());
        stats.put("activitesCompletes", getActivitesCompletes().size());
        stats.put("activitesDisponibles", getActivitesDisponibles().size());
        stats.put("adherentsInscritsUniques", calculerNombreTotalAdherentsInscrits());
        return stats;
    }

    public void chargerDonneesExemple() {
        ajouterAdherent(new Adherent(1, "Dupont", "Alice", 24, "0600000001", "alice.dupont@mail.com"));
        ajouterAdherent(new Adherent(2, "Martin", "Lucas", 30, "0600000002", "lucas.martin@mail.com"));
        ajouterAdherent(new Adherent(3, "Bernard", "Emma", 27, "0600000003", "emma.bernard@mail.com"));

        ajouterActivite(new Activite(101, "Yoga", "Sophie Laurent", 2, "Lundi 18h00"));
        ajouterActivite(new Activite(102, "Cardio Training", "Mehdi Karim", 3, "Mardi 19h00"));
        ajouterActivite(new Activite(103, "Cross Training", "Nina Robert", 2, "Jeudi 17h30"));

        inscrireAdherent(1, 101);
        inscrireAdherent(2, 101);
        inscrireAdherent(3, 102);
    }
}

import java.time.LocalDate;

public class Inscription {
    private Adherent adherent;
    private Activite activite;
    private LocalDate dateInscription;
    private StatutInscription statut;

    public Inscription(Adherent adherent, Activite activite, LocalDate dateInscription) {
        this.adherent = adherent;
        this.activite = activite;
        this.dateInscription = dateInscription;
        this.statut = StatutInscription.ACTIVE;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public Activite getActivite() {
        return activite;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public StatutInscription getStatut() {
        return statut;
    }

    public boolean estActive() {
        return statut == StatutInscription.ACTIVE;
    }

    public void annulerInscription() {
        this.statut = StatutInscription.ANNULEE;
    }

    public String afficherInscription() {
        return "Inscription{" +
                "adherent=" + adherent.getPrenom() + " " + adherent.getNom() +
                ", activite=" + activite.getNomActivite() +
                ", dateInscription=" + dateInscription +
                ", statut=" + statut + '}';
    }

    @Override
    public String toString() {
        return adherent.getPrenom() + " " + adherent.getNom() +
                " -> " + activite.getNomActivite() +
                " | Date: " + dateInscription +
                " | Statut: " + statut;
    }
}

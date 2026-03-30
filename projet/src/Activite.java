public class Activite {

    private int id;
    private String nomActivite;
    private String coach;
    private int capaciteMax;
    private String horaire;

    public Activite(int id, String nomActivite, String coach, int capaciteMax, String horaire) {
        this.id = id;
        this.nomActivite = nomActivite;
        this.coach = coach;
        this.capaciteMax = capaciteMax;
        this.horaire = horaire;
    }

    public int getId() {
        return id;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public boolean estComplete(int nbInscritsActifs) {
        return nbInscritsActifs >= capaciteMax;
    }

    public String afficherDetails() {
        return "Activite{" +
                "id=" + id +
                ", nomActivite='" + nomActivite + '\'' +
                ", coach='" + coach + '\'' +
                ", capaciteMax=" + capaciteMax +
                ", horaire='" + horaire + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return id + " - " + nomActivite + " | Coach: " + coach + " | Capacité: " + capaciteMax + " | Horaire: " + horaire;
    }
}

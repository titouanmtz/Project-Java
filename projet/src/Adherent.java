public class Adherent {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String telephone;
    private String email;

    public Adherent(int id, String nom, String prenom, int age, String telephone, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String afficherDetails() {
        return "Adherent{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return id + " - " + prenom + " " + nom + " (" + age + " ans)";
    }
}

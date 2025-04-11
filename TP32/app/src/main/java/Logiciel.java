public class Logiciel {
    private String nom;
    private String description;
    private int imageResource;

    // Constructeur d'initialisation
    public Logiciel(String nom, String description, int imageResource) {
        this.nom = nom;
        this.description = description;
        this.imageResource = imageResource;
    }

    // Getter pour le nom du logiciel
    public String getNom() {
        return nom;
    }

    // Setter pour le nom du logiciel
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour la description du logiciel
    public String getDescription() {
        return description;
    }

    // Setter pour la description du logiciel
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter pour l'image du logiciel
    public int getImageResource() {
        return imageResource;
    }

    // Setter pour l'image du logiciel
    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}

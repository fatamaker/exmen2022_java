public class Ordinatuer extends MaterielInfo implements Affichable{
    private String marque;
    private String description;
    private String[] connexions;

    public Ordinateur(long l, double p, int q, String marque, String description, String[] connexions) {
        super(l, p, q); 
        this.marque = marque;
        this.description = description;
        this.connexions = connexions;
    }

    @Override
    double prixVente() {
        return prix_hors_tax * 1.15;
    }

    @Override
    public void afficheToi() {
        System.out.println("Prix hors taxe : " + prix_hors_tax);
        System.out.println("Prix de vente (avec 15% ajouté) : " + prixVente());
    }


}

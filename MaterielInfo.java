public class MaterielInfo {
  
    protected long reference;
    private double prix_hors_tax;
    private int quantite;

   
    public MaterielInfo(long l) {
        this.reference = l;
    }

   
    public MaterielInfo(long l, double p, int q) {
        this(l);
        this.prix_hors_tax = p;
        this.quantite = q;
    }

    
    public double getPrixHorsTax() {
        return prix_hors_tax;
    }

   
    public void setPrixHorsTax(double prix_hors_tax) {
        this.prix_hors_tax = prix_hors_tax;
    }

  
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

  
    public long getReference() {
        return reference;
    }

    
    public void setReference(long reference) {
        this.reference = reference;
    }

    public boolean equals(MaterielInfo m){
       return this.reference=m.reference;
    }

     @Override
    public String toString() {
        return  " ref : " + reference + " prixHt :" +prix_hors_tax + "quantite :" + quantite ;
 
    }

    abstract double prixVente();
}

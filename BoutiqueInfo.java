public class BoutiqueInfo {

    public MaterielInfo[] materiels;
    public static final int capacite = 100;
    int nbMatriels ;
 

    public BoutiqueInfo (){
        this.materiels= new MaterielInfo[capascite];
        this.nbMatriels=0;
    }


    public void ajoutMateriel(MaterielInfo i) throws ExceptionQte{
        int pos =recherche(i.getReference());
        if (nbMatriels == capacite){
            throw new ExceptionQte("la capacite est au max .");
        }
        else {
            if (pos ==-1){
                materiels[nbMatriels]=i;
                nbMatriels++;
            }
            else {
                materiels[pos].getQuantite()++;
            }
           
        }   

    }


    public int recherche(long ref) {
        int position=-1;
        for (int i = 0; i <nbMatriels ; i++) {
            if (materiels[i].getReference() == ref) {
                return i; 
            }
        };
        return position;
        }

    public void venteMateriel(long ref, int qte) throws ExceptionQte{
        int pos = recherche(ref);
        if (pos!=-1){
            if (materiels[pos].getQuantite()<qte){
                throw new ExceptionQte("la quantite est insuffisante .");
            }
            else {
                materiels[pos].setQuantite(materiels[pos].getQuantite() - qte);  
                System.out.println("la quantite est vendue");
            }

        }
        else {
            System.out.println("cette referance n'exsite pas");
        }


    }

    public static void main(String[] args) {

        try {

        BoutiqueInfo boutique =new BoutiqueInfo();

        String [] connexions1 = {"4usb", "ble"};
        String [] connexions2 = {"4usb", "ble","wifi"};

        MaterielInfo materiel1= new Ordinateur(1,1800,4,"DELL intel i3 2,5 4 15 500",connexions1);
        MaterielInfo materiel2 = new Ordinateur(2,2000,7,"HP intel i5 4 8 15 1024",connexions2);
        boutique.ajoutMateriel(materiel1);
        boutique.ajoutMateriel(materiel2);

        for (int i=0;i<boutique.nbMateriels;i++){
            System.out.println("Référence: " + boutique.materiels[i].getReference() + ", Quantité: " + boutique.materiels[i].getQuantite() + ", Description: " + boutique.materiels[i].getDescription());
        }
        double s;
        for (int i=0;i<boutique.nbMateriels;i++){
            s= boutique.materiels[i].prixVente();
        }

        boutique.venteMateriel(1,2);  // Cela devrait réussir
        boutique.venteMateriel(1,3);  // Cela devrait échouer, exception levée
        
      }
      catch (ExceptionQte e) {
        System.out.println("Erreur : " + e.getMessage());
    }
    }


    
}

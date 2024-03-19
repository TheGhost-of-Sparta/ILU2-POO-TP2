package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Quel produit voulez vous acheter ?");
			String produit = scan.next();
			String[] donnee=controlAcheterProduit.getVendeur(produit);
			if (donnee.length==0) {
				System.out.println("Désolé, personne ne vend ce produit.");
			} else {
				StringBuilder res = new StringBuilder();
				for (int k=0;k<donnee.length;k=k+3) {
					if (donnee[k+2].equals(produit)) {
						res.append(k);
						res.append(" - ");
						res.append(donnee[k]+"\n");
					}
				}
				System.out.println(res);
				System.out.println("Chez quel commerçant souhaitez vous acheter des "+ produit+ " ?");
				String entier = scan.next();
				int nb=Integer.parseInt(entier);
				System.out.println("Panoramix se déplace jusqu'à l'étal du vendeur " + donnee[nb]+ "\n");
				System.out.println("Bonjour "+ nomAcheteur);
				int nb2 =Clavier.entrerEntier("Combien de " + produit +" voulez vous acheter ?");
				if (nb2 > Integer.parseInt(donnee[nb+1]) && Integer.parseInt(donnee[nb+1])!=0) {
					System.out.println(nomAcheteur + " veut acheter " + nb2 + " " + produit +"mais " + donnee[nb] + " n'en a plus que " + donnee[nb+1] + ". " + nomAcheteur + " achète tout le stock.");
					controlAcheterProduit.acheterProduit(donnee[nb],Integer.parseInt(donnee[nb+1]));	
				} else if(nb2 > Integer.parseInt(donnee[nb+1]) && Integer.parseInt(donnee[nb+1])==0){
					System.out.println(nomAcheteur +" veut acheter " + produit +" malheureusement il n'y en a plus.");
				} else {
					System.out.println(nomAcheteur + " achète " + nb2 + " "+ produit);
					controlAcheterProduit.acheterProduit(donnee[nb],nb2);	
				}
			}
		} else {
			System.out.println("Il faut être un habitant du village pour pouvoir acheter au marché.");
		}
	}
}

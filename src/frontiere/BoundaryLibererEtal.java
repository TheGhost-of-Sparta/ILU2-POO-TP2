package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(controlLibererEtal.isVendeur(nomVendeur)==false){
			System.out.println("Vous n'êtes pas inscrit au marché.");
		} else {
			String[] donnees=controlLibererEtal.libererEtal(nomVendeur);
			StringBuilder liberation = new StringBuilder();
			liberation.append("Vous avez vendu ");
			liberation.append(donnees[4]);
			liberation.append(" sur ");
			liberation.append(donnees[3]);
			liberation.append(" ");
			liberation.append(donnees[2]);
			System.out.println(liberation);
		}
	}

}

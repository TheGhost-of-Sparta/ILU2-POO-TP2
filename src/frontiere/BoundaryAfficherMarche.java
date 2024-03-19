package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] donnees=controlAfficherMarche.donnerInfosMarche();
		if (donnees.length==0) {
			System.out.println("Le marché est vide revenez plus tard.");
			
		} else {
			StringBuilder res = new StringBuilder();
			res.append(nomAcheteur);
			res.append(" vous trouverez au marché.\n");
			for (int k =0;k<donnees.length;k++) {
				res.append("- ");
				res.append(donnees[k]);
				k++;
				res.append(" qui vend ");
				res.append(donnees[k]);
				k++;
				res.append(" ");
				res.append(donnees[k]);
				res.append("\n");
			}
			System.out.println(res);
		}
	}
}

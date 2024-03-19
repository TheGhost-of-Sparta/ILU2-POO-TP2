package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Bonjour " + nomVendeur + "je vais regarder si je peux vous trouver un étal.");
			if (controlPrendreEtal.resteEtals()) {
				this.installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignement supplémentaires.");
		System.out.println("Que souhaitez vous vendre ?");
		String nom = scan.next();
		int nb =Clavier.entrerEntier("Combien souhaitez vous en vendre ?");
		int numero =controlPrendreEtal.prendreEtal(nomVendeur, nom, nb);
		System.out.println("Le vendeur"+nomVendeur+" s'est installé à l'étal n° "+numero);


	}
}

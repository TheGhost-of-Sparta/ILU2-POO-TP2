package controleur;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean isVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)!=null;
	}

	public String[] libererEtal(String nomVendeur) {
		controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).libererEtal();
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).donneesVente();
	}

}

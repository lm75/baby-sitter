
public class BabySitter {

	private String nom;
	private Enfant enfant;
	
	public BabySitter(String nom) {
		enfant = null;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public boolean isDisponible() {
		if (enfant == null) {
			return true;
		}
		return false;
	}

	public boolean faireDormirEnfant() {
		if(enfant.getStatut() == StatutEnfant.EnfantAMange){
			enfant.setStatut(StatutEnfant.EnfantADormi);
			return true;
		}
		return false;
	}

	public boolean nourrirEnfant() {
		if(enfant.getStatut() == StatutEnfant.EnfantChezBS){
			enfant.setStatut(StatutEnfant.EnfantAMange);
			return true;
		}
		return false;
	}

	public void libererEnfant() {
		enfant = null;
	}

	public void garderEnfant(Enfant e) {
		enfant = e;
	}

}

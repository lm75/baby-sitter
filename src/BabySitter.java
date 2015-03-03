
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
		if(!isDisponible() && enfant.getStatut() instanceof EnfantAMange){
			enfant.faireDormirEnfant();
			return true;
		}
		return false;
	}

	public boolean nourrirEnfant() {
		if(!isDisponible() && enfant.getStatut() instanceof EnfantChezBS){
			enfant.nourrirEnfant();
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

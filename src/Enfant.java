
public class Enfant {
	
	private StatutEnfant statut;
	private String nom;

	public Enfant(String nomEnfant) {
		nom = nomEnfant;
		statut = new EnfantChezParent();
	}

	public StatutEnfant getStatut() {
		return statut;
	}

	public String getNom() {
		return nom;
	}

	public void setStatut(StatutEnfant statut) {
		this.statut = statut;
	}
	
	
	public void faireDormirEnfant(){
		statut.faireDormirEnfant(this);
	}
	
	public void nourrirEnfant(){
		statut.nourrirEnfant(this);
	}
	
	public void libererEnfant(){
		statut.libererEnfant(this);
	}
	
	public void garderEnfant(){
		statut.garderEnfant(this);
	}

}


public class Enfant {
	
	private StatutEnfant statut;
	private StatusEnfant status;
	private String nom;

	public Enfant(String nomEnfant) {
		nom = nomEnfant;
		statut = StatutEnfant.EnfantChezParent;
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
	
	public void setStatus(StatusEnfant statut) {
		this.status = statut;
	}

}

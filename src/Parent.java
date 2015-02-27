import java.util.ArrayList;


public class Parent {

	private String nom;
	private ArrayList<Enfant> listeEnfants;
	
	
	public Parent(String nom) {
		this.nom = nom;
		listeEnfants = new ArrayList<Enfant>();
	}

	public String getNom() {
		return nom;
	}

	public int getNombreEnfant() {
		return listeEnfants.size();
	}
	
	/**
	 * 
	 * @param nomEnfant
	 * @return
	 */
	private boolean isEnfantDejaPresent(String nomEnfant){
		for( Enfant e : listeEnfants )
		{
			if ( e.getNom().equals(nomEnfant)){
				return true;
			}
		}
		return false;
	}
	
	private Enfant rechercherEnfant(String nomEnfant)
	{
		for( Enfant e : listeEnfants )
		{
			if ( e.getNom().equals(nomEnfant)){
				return e;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param nomEnfant
	 * @return Enfant l'enfant cr��
	 * 			null si enfant existe d�j�
	 */
	public Enfant creerEnfant(String nomEnfant) {
		if (!isEnfantDejaPresent(nomEnfant)) {
			Enfant e = new Enfant(nomEnfant);
			listeEnfants.add(e);
			return e;
		}
		return null;
	}

	public boolean recupererEnfant(String nom, BabySitter bs) {
		Enfant e = rechercherEnfant(nom);
		if(e.getStatut() == StatutEnfant.EnfantChezParent)
		{
			return false;
		}
		e.setStatut(StatutEnfant.EnfantChezParent);
		bs.libererEnfant();
		return true;
	}

	public boolean amenerEnfantBS(String nomEnfant, BabySitter bs) {
		if (isEnfantDejaPresent(nomEnfant) && bs.isDisponible()){
			Enfant e = rechercherEnfant(nomEnfant);
			e.setStatut(StatutEnfant.EnfantChezBS);;
			bs.garderEnfant(e);
			return true;
		}
		return false;
	}

}

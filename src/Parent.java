import java.util.ArrayList;


public class Parent implements AbstractContainer {

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
	public boolean isEnfantDejaPresent(String nomEnfant){
		EnfantIterator ei = (EnfantIterator)getIterator();
		while ( ei.hasNext() )
		{
			Enfant e = (Enfant)ei.next();
			if ( e.getNom().equals(nomEnfant) ){
				return true;
			}
		}
		return false;
	}
	
	public Enfant rechercherEnfant(String nomEnfant)
	{
		EnfantIterator ei = (EnfantIterator)getIterator();
		while ( ei.hasNext() )
		{
			Enfant e = (Enfant)ei.next();
			if ( e.getNom().equals(nomEnfant) ){
				return e;
			}
		}
		return null;
	}
	
	public void listerEnfants()
	{
		AbstractIterator ei = getIterator();
		while ( ei.hasNext() )
		{
			Enfant e = (Enfant)ei.next();
			System.out.println( e.getNom() );
		}
	}
	
	/**
	 * 
	 * @param nomEnfant
	 * @return Enfant l'enfant créé
	 * 			null si enfant existe déjà
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
		if(e.getStatut() instanceof EnfantChezParent)
		{
			return false;
		}
		e.libererEnfant();
		if (bs == null){
			GestionBabySitter gbs = GestionBabySitter.getInstance();
			AbstractIterator lbs = gbs.getIterator();
			while (lbs.hasNext())
			{
				bs = (BabySitter)lbs.next();
				if(bs.getEnfant().getNom().equals(nom)){
					break;
				}
			}
		}
		bs.libererEnfant();
		return true;
	}

	public boolean amenerEnfantBS(String nomEnfant, BabySitter bs) {
		if (isEnfantDejaPresent(nomEnfant) && bs.isDisponible()){
			Enfant e = rechercherEnfant(nomEnfant);
			e.garderEnfant();
			bs.garderEnfant(e);
			return true;
		}
		return false;
	}
	
	@Override
	public EnfantIterator getIterator() {
		return new EnfantIterator();
	}

	private class EnfantIterator implements AbstractIterator {

	      int index = 0;

	      @Override
	      public boolean hasNext() {
	      
	         if(index < listeEnfants.size()){
	            return true;
	         }
	         return false;
	      }

	      @Override
	      public Object next() {
	      
	         if(this.hasNext()){
	            return listeEnfants.get(index++);
	         }
	         return null;
	      }		
	 }

}

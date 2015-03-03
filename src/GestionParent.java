import java.util.ArrayList;


public class GestionParent implements AbstractContainer {

	private ArrayList<Parent> listeParent;
	
	/** Constructeur privé */
	private GestionParent()
	{
		listeParent = new ArrayList<Parent>();
	}
	
	/** Instance unique pré-initialisée */
	private static GestionParent INSTANCE = new GestionParent();
	
	/** Point d'accès pour l'instance unique du singleton */
	public static GestionParent getInstance()
	{	
		return INSTANCE;
	}
	
	public boolean creerParent(String nom)
	{
		if(!isParentDejaPresent(nom))
		{
			listeParent.add(new Parent(nom));
			return true;
		}
		return false;
	}
	
	public boolean isParentDejaPresent(String nomParent)
	{
		AbstractIterator pi = getIterator();
		while ( pi.hasNext() )
		{
			Parent p = (Parent)pi.next();
			if ( p.getNom().equals(nomParent) ){
				return true;
			}
		}
		return false;
	}
	
	public Parent rechercherParent(String parent)
	{
		AbstractIterator pi = getIterator();
		while ( pi.hasNext() )
		{
			Parent p = (Parent)pi.next();
			if ( p.getNom().equals(parent) ){
				return p;
			}
		}
		return null;
	}
	
	public void listerParent()
	{
		AbstractIterator pi = getIterator();
		while ( pi.hasNext() )
		{
			Parent p = (Parent)pi.next();
			System.out.println(p.getNom());
		}
	}
	
	@Override
	public ParentIterator getIterator() {
		return new ParentIterator();
	}

	private class ParentIterator implements AbstractIterator {

	      int index = 0;

	      @Override
	      public boolean hasNext() {
	      
	         if(index < listeParent.size()){
	            return true;
	         }
	         return false;
	      }

	      @Override
	      public Object next() {
	      
	         if(this.hasNext()){
	            return listeParent.get(index++);
	         }
	         return null;
	      }		
	 }
	
	/**
	 * 
	 * @param nomParent
	 * @return
	 */
	public boolean isEnfantDejaPresent(String nomParent,String nomEnfant){
		Parent op = rechercherParent(nomParent);
		AbstractIterator pi = op.getIterator();
		if ( pi.hasNext() )
		{
			Enfant e = (Enfant)pi.next();
			if ( e.getNom().equals(nomEnfant) ){
				return true;
			}
		}
		return false;
	}
	
	public Enfant rechercherEnfant(String nomParent, String nomEnfant)
	{
		Parent op = rechercherParent(nomParent);
		AbstractIterator pi = op.getIterator();
		if ( pi.hasNext() )
		{
			Enfant e = (Enfant)pi.next();
			if ( e.getNom().equals(nomEnfant) ){
				return e;
			}
		}
		return null;
	}
}

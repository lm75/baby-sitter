import java.util.ArrayList;


public class GestionBabySitter implements AbstractContainer {
	
	private ArrayList<BabySitter> listeBS;
	
	/** Constructeur privé */
	private GestionBabySitter()
	{
		listeBS = new ArrayList<BabySitter>();
	}
	
	/** Instance unique pré-initialisée */
	private static GestionBabySitter INSTANCE = new GestionBabySitter();
	
	/** Point d'accès pour l'instance unique du singleton */
	public static GestionBabySitter getInstance()
	{	
		return INSTANCE;
	}
	
	public boolean creerBS(String nom)
	{
		if(!isBSDejaPresente(nom))
		{
			listeBS.add(new BabySitter(nom));
			return true;
		}
		return false;
	}
	
	public boolean isBSDejaPresente(String nomBS)
	{
		AbstractIterator pi = (BSIterator) getIterator();
		while ( pi.hasNext() )
		{
			BabySitter p = (BabySitter)pi.next();
			if ( p.getNom().equals(nomBS) ){
				return true;
			}
		}
		return false;
	}
	
	public BabySitter rechercherBS(String BS)
	{
		AbstractIterator pi = (BSIterator) getIterator();
		while ( pi.hasNext() )
		{
			BabySitter p = (BabySitter)pi.next();
			if ( p.getNom().equals(BS) ){
				return p;
			}
		}
		return null;
	}
	
	public void listerBS()
	{
		AbstractIterator bi = getIterator();
		while ( bi.hasNext() )
		{
			BabySitter b = (BabySitter)bi.next();
			System.out.println(b.getNom());
		}
	}
	
	public void listerBSdisponible()
	{
		AbstractIterator bi = getIterator();
		while ( bi.hasNext() )
		{
			BabySitter b = (BabySitter)bi.next();
			if(b.isDisponible())
			{
				System.out.println(b.getNom());
			}
		}
	}
	
	@Override
	public BSIterator getIterator() {
		return new BSIterator();
	}
	
	private class BSIterator implements AbstractIterator {

	      int index = 0;

	      @Override
	      public boolean hasNext() {
	      
	         if(index < listeBS.size()){
	            return true;
	         }
	         return false;
	      }

	      @Override
	      public Object next() {
	      
	         if(this.hasNext()){
	            return listeBS.get(index++);
	         }
	         return null;
	      }		
	 }
}

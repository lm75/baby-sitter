import junit.framework.TestCase;


public class TestsUnitaires extends TestCase {

	public void testParent(){
		Parent p = new Parent("Magali");
		assertEquals(p.getNom(), "Magali");
		assertEquals(p.getNombreEnfant(),0);
		
		p.creerEnfant("Magali");
		assertEquals(p.getNombreEnfant(), 1);
	}
	
	public void testIsEnfantDejaPresent() {
		Parent p = new Parent("Magali");
		assertFalse(p.isEnfantDejaPresent("Magali"));
		
		p.creerEnfant("Magali");
		assertTrue(p.isEnfantDejaPresent("Magali"));
	}
	
	public void testRechercherEnfant() {
		Parent p = new Parent("Magali");
		assertEquals(p.rechercherEnfant("Magali"), null);
		
		Enfant e = p.creerEnfant("Magali");
		assertEquals(p.rechercherEnfant("Magali"), e);
	}
	
	public void testParentAmeneEnfantBS(){
		Parent p = new Parent("Magali");
		Enfant e = p.creerEnfant("Magali");
		
		assertTrue(e.getStatut() instanceof EnfantChezParent);
		BabySitter bs = new BabySitter("Magali");
		p.amenerEnfantBS("Magali", bs);
		assertTrue(e.getStatut() instanceof EnfantChezBS);
	}
	
	public void testParentRecupererEnfant(){
		Parent p = new Parent("Magali");
		p.creerEnfant("Magali");
		
		BabySitter bs = new BabySitter("Magali");
		p.amenerEnfantBS("Magali", bs);
		assertTrue(p.recupererEnfant("Magali", bs));
	}
	
	public void testIsDisponible() {
		BabySitter bs = new BabySitter("Magali");
		assertEquals(bs.getNom(),"Magali");
		assertTrue(bs.isDisponible());
		
		Parent p = new Parent("Magali");
		Enfant e = p.creerEnfant("Magali");
		
		p.amenerEnfantBS("Magali", bs);
		assertFalse(bs.isDisponible());
	}
	
	public void testBabySittersuite() {
		Parent p = new Parent("Magali");
		Enfant e = p.creerEnfant("Magali");
		
		BabySitter bs = new BabySitter("Magali");
		p.amenerEnfantBS("Magali", bs);
		assertFalse(bs.faireDormirEnfant());
		assertTrue(bs.nourrirEnfant());
		assertTrue(e.getStatut() instanceof EnfantAMange);
		assertTrue(bs.faireDormirEnfant());
		assertTrue(e.getStatut() instanceof EnfantADormi);
	}
	
	public void testEnfant() {
		Enfant e = new Enfant("Magali");
		assertEquals(e.getNom(),"Magali");
		assertTrue(e.getStatut() instanceof EnfantChezParent);
		e.garderEnfant();
		assertTrue(e.getStatut() instanceof EnfantChezBS);
		e.libererEnfant();
		assertTrue(e.getStatut() instanceof EnfantChezParent);
	}
}


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
		
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezParent);
		BabySitter bs = new BabySitter("Magali");
		p.amenerEnfantBS("Magali", bs);
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezBS);
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
		assertEquals(e.getStatut(), StatutEnfant.EnfantAMange);
		assertTrue(bs.faireDormirEnfant());
		assertEquals(e.getStatut(), StatutEnfant.EnfantADormi);
	}
	
	public void testEnfant() {
		Enfant e = new Enfant("Magali");
		assertEquals(e.getNom(),"Magali");
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezParent);
		e.setStatut(StatutEnfant.EnfantChezBS);
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezBS);
		e.setStatut(StatutEnfant.EnfantChezParent);
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezParent);
	}
}


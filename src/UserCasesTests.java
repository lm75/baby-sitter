import junit.framework.TestCase;


public class UserCasesTests extends TestCase {
	
	/**
	 * 
	 */
	public void testCreationParent(){
		// On créé un parent
		Parent p = new Parent("GUILLAUME");
		assertEquals(p.getNom(), "GUILLAUME");
		// le parent est initialisé sans enfant
		assertEquals(p.getNombreEnfant(),0);
	}
	
	public void testAjoutEnfant(){
		Parent p = new Parent("GUILLAUME");
		// le parent est initialisé sans enfant
		assertEquals(p.getNombreEnfant(),0);
		// les parents créé un enfant
		Enfant e = p.creerEnfant("Josselin");
		// Le nombre d'enfant de ces parents passe à 1
		assertEquals(p.getNombreEnfant(), 1);
		// le status initial de l'enfant est "EnfantChezParent"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezParent);
	}
	
	public void testCreationBabySitter(){
		// On créé une baby-Sitter
		BabySitter bs = new BabySitter("Magali");
		assertEquals(bs.getNom(),"Magali");
		// la BS est initalisée sans enfant à charge
		assertTrue(bs.isDisponible());
	}
	
	public void testParentAmeneEnfantBS(){
		// On créé un parent
		Parent p = new Parent("GUILLAUME");
		// les parents créé un enfant
		Enfant e = p.creerEnfant("Josselin");
		// le status initial de l'enfant est "EnfantChezParent"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezParent);
		// On créé une baby-Sitter
		BabySitter bs = new BabySitter("Magali");
		// On affecte l'enfant précèdant à la baby sitter
		p.amenerEnfantBS("Josselin", bs);
		// Le statut de l'enfant doit être "EnfantChezBS"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezBS);
		// La bs n'est plus disponible
		assertFalse(bs.isDisponible());
	}
	
	public void testBSManageEnfant(){
		Parent p = new Parent("GUILLAUME");
		Enfant e = p.creerEnfant("Josselin");
		BabySitter bs = new BabySitter("Magali");
		p.amenerEnfantBS("Josselin", bs);
		// Le statut de l'enfant doit être "EnfantChezBS"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezBS);
		assertFalse(bs.faireDormirEnfant());
		assertTrue(bs.nourirEnfant());
		assertEquals(e.getStatut(), StatutEnfant.EnfantAMange);
		assertTrue(bs.faireDormirEnfant());
		assertEquals(e.getStatut(), StatutEnfant.EnfantADormi);
		assertFalse(bs.nourirEnfant());
	}
	
	public void testParentRecupereEnfant(){
		Parent p = new Parent("GUILLAUME");
		Enfant e = p.creerEnfant("Josselin");
		BabySitter bs = new BabySitter("Magali");
		p.amenerEnfantBS("Josselin", bs);
		
		assertTrue(p.recupererEnfant("Josselin", bs));
	}
	
	/**
	 * JoGui
	 */
	public void test1(){
		// On créé un parent
		Parent p = new Parent("GUILLAUME");
		// le parent est initialisé sans enfant
		assertEquals(p.getNombreEnfant(),0);
		// les parents créé un enfant
		Enfant e = p.creerEnfant("Josselin");
		// Le nombre d'enfant de ces parents passe à 1
		assertEquals(p.getNombreEnfant(), 1);
		// le status initial de l'enfant est "EnfantChezParent"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezParent);
		// On créé une baby-Sitter
		BabySitter bs = new BabySitter("Magali");
		// On affecte l'enfant précèdant à la baby sitter
		p.amenerEnfantBS("Josselin", bs);
		// Le statut de l'enfant doit être "EnfantChezBS"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezBS);
		// L'enfant ne peut pas aller dormir sans avoir manger
		assertFalse(bs.faireDormirEnfant());
		assertTrue(bs.nourirEnfant());
		assertEquals(e.getStatut(), StatutEnfant.EnfantAMange);
		// La baby sitter endort l'enfant
		assertTrue(bs.faireDormirEnfant());
		// Le status de l'enfant doit etre passé "EnfantADormi"
		assertEquals(e.getStatut(), StatutEnfant.EnfantADormi);
		// L'enfant qui a dormi ne peut pas etre nourri
		assertFalse(bs.nourirEnfant());
		Parent p1 = new Parent("MARY");
		p1.creerEnfant("Laurent");
		// La baby-sitter ne peut avoir en charge qu'un seul enfant
		assertFalse(p1.amenerEnfantBS("Laurent", bs));
		// les parents p viennent chercher leur enfant
		assertTrue(p.recupererEnfant("Josselin", bs));
		// le status de l'enfant repasse à "EnfantChezParent"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezParent);
		
	}
}

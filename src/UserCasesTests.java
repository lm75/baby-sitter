import junit.framework.TestCase;


public class UserCasesTests extends TestCase {
	
	
	/**
	 * 
	 */
	public void testCreationParent(){
		// On cr�� un parent
		Parent p = new Parent("GUILLAUME");
		assertEquals(p.getNom(), "GUILLAUME");
		// le parent est initialis� sans enfant
		assertEquals(p.getNombreEnfant(),0);
	}
	
	public void testAjoutEnfant(){
		Parent p = new Parent("GUILLAUME");
		// le parent est initialis� sans enfant
		assertEquals(p.getNombreEnfant(),0);
		// les parents cr�� un enfant
		Enfant e = p.creerEnfant("Josselin");
		// Le nombre d'enfant de ces parents passe � 1
		assertEquals(p.getNombreEnfants(), 1);
		// le status initial de l'enfant est "EnfantChezParent"
		assertEquals(e.getStatus(), "EnfantChezParent");
	}
	
	public void testCreationBabySitter(){
		// On cr�� une baby-Sitter
		BabySitter bs = new BabySitter("Magali");
		assertEquals(bs.getNom(),"Magali");
		// la BS est initalis�e sans enfant � charge
		assertTrue(bs.isDisponible());
	}
	
	public void testParentAmeneEnfantBS(){
		// On cr�� un parent
		Parent p = new Parent("GUILLAUME");
		// les parents cr�� un enfant
		Enfant e = p.creerEnfant("Josselin");
		// le status initial de l'enfant est "EnfantChezParent"
		assertEquals(e.getStatus(), "EnfantChezParent");
		// On cr�� une baby-Sitter
		BabySitter bs = new BabySitter("Magali");
		// On affecte l'enfant pr�c�dant � la baby sitter
		p.garderEnfant("Josselin", bs);
		// Le status de l'enfant doit �tre "EnfantChezBS"
		assertEquals(e.getStatus(), "EnfantChezBS");
		// La bs n'est plus disponible
		assertFalse(bs.isDisponible());
	}
	
	public void testBSManageEnfant(){
		Parent p = new Parent("GUILLAUME");
		Enfant e = p.creerEnfant("Josselin");
		BabySitter bs = new BabySitter("Magali");
		p.garderEnfant("Josselin", bs);
		// Le status de l'enfant doit �tre "EnfantChezBS"
		assertEquals(e.getStatus(), "EnfantChezBS");
		assertFalse(bs.faireDormirEnfant());
		assertTrue(bs.nourirEnfant());
		assertEquals(e.getStatus(), "EnfantAMange");
		assertTrue(bs.faireDormirEnfant());
		assertEquals(e.getStatus(), "EnfantChezBS");
		assertFalse(bs.nourirEnfant());
	}
	
	public void testParentRecupereEnfant(){
		Parent p = new Parent("GUILLAUME");
		Enfant e = p.creerEnfant("Josselin");
		BabySitter bs = new BabySitter("Magali");
		p.garderEnfant("Josselin", bs);
		
		assertTrue(p.recupererEnfant("Josselin"));
	}
	
	/**
	 * JoGui
	 */
	public void test1(){
		// On cr�� un parent
		Parent p = new Parent("GUILLAUME");
		// le parent est initialis� sans enfant
		assertEquals(p.getNombreEnfant(),0);
		// les parents cr�� un enfant
		Enfant e = p.creerEnfant("Josselin");
		// Le nombre d'enfant de ces parents passe � 1
		assertEquals(p.getNombreEnfants(), 1);
		// le status initial de l'enfant est "EnfantChezParent"
		assertEquals(e.getStatus(), "EnfantChezParent");
		// On cr�� une baby-Sitter
		BabySitter bs = new BabySitter("Magali");
		// On affecte l'enfant pr�c�dant � la baby sitter
		p.garderEnfant("Josselin", bs);
		// Le status de l'enfant doit �tre "EnfantChezBS"
		assertEquals(e.getStatus(), "EnfantChezBS");
		// L'enfant ne peut pas aller dormir sans avoir manger
		assertFalse(bs.faireDormirEnfant());
		assertTrue(bs.nourirEnfant());
		assertEquals(e.getStatus(), "EnfantAMang�");
		// La baby sitter endort l'enfant
		assertTrue(bs.faireDormirEnfant());
		// Le status de l'enfant doit etre pass� "EnfantADormi"
		assertEquals(e.getStatus(), "EnfantADormi");
		// L'enfant qui a dormi ne peut pas etre nourri
		assertFalse(bs.nourirEnfant());
		Parent p1 = new Parent("MARY");
		p1.creerEnfant("Laurent");
		// La baby-sitter ne peut avoir en charge qu'un seul enfant
		assertFalse(p1.garderEnfant("Laurent", bs));
		// les parents p viennent chercher leur enfant
		assertTrue(p.recupererEnfant("Josselin"));
		// le status de l'enfant repasse � "EnfantChezParent"
		assertEquals(e.getStatus(), "EnfantChezParent");
		
	}
}


public class UserCasesTests {
	
	
	/**
	 * 
	 */
	public void testCreationParent(){
		// On cr�� un parent
		Parent p = new Parent("GUILLAUME");
		assertTrue(p.getNom(), "GUILLAUME");
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
		AssertEquals(p.getNombreEnfants(), 1);
		// le status initial de l'enfant est "EnfantChezParent"
		AssertEquals(e.getStatus(), "EnfantChezParent");
	}
	
	public void testCreationBabySitter(){
		// On cr�� une baby-Sitter
		BabySitter bs = new BabySitter("Magali");
		AssertEquals(bs.getNom(),"Magali");
		// la BS est initalis�e sans enfant � charge
		AssertTrue(bs.isDisponible());
	}
	
	public void testParentAmeneEnfantBS(){
		// On cr�� un parent
		Parent p = new Parent("GUILLAUME");
		// les parents cr�� un enfant
		Enfant e = p.creerEnfant("Josselin");
		// le status initial de l'enfant est "EnfantChezParent"
		AssertEquals(e.getStatus(), "EnfantChezParent");
		// On cr�� une baby-Sitter
		BabySitter bs = new BabySitter("Magali");
		// On affecte l'enfant pr�c�dant � la baby sitter
		p.garderEnfant("Josselin", bs);
		// Le status de l'enfant doit �tre "EnfantChezBS"
		AssertEquals(e.getStatus(), "EnfantChezBS");
		// La bs n'est plus disponible
		AssertFalse(bs.estDisponible());
	}
	
	public void testBSManageEnfant(){
		Parent p = new Parent("GUILLAUME");
		Enfant e = p.creerEnfant("Josselin");
		BabySitter bs = new BabySitter("Magali");
		p.garderEnfant("Josselin", bs);
		// Le status de l'enfant doit �tre "EnfantChezBS"
		AssertEquals(e.getStatus(), "EnfantChezBS");
		AssertFalse(bs.faireDormirEnfant());
		AssertTrue(bs.nourirEnfant());
		AssertEquals(e.getStatus, "EnfantAMange");
		AssertTrue(bs.faireDormirEnfant());
		AssertTrue(e.getStatus(), "EnfantChezBS");
		AssertFalse(bs.nourirEnfant());
	}
	
	public void testParentRecupereEnfant(){
		Parent p = new Parent("GUILLAUME");
		Enfant e = p.creerEnfant("Josselin");
		BabySitter bs = new BabySitter("Magali");
		p.garderEnfant("Josselin", bs);
		
		AssertTrue(p.RecupereEnfant("Josselin"));
	}
	
	/**
	 * JoGui
	 */
	public static void test1{
		// On cr�� un parent
		Parent p = new Parent("GUILLAUME");
		// le parent est initialis� sans enfant
		assertEquals(p.getNombreEnfant(),0);
		// les parents cr�� un enfant
		Enfant e = p.creerEnfant("Josselin");
		// Le nombre d'enfant de ces parents passe � 1
		AssertEquals(p.getNombreEnfants(), 1);
		// le status initial de l'enfant est "EnfantChezParent"
		AssertEquals(e.getStatus(), "EnfantChezParent");
		// On cr�� une baby-Sitter
		BabySitter bs = new BabySitter("Magali");
		// On affecte l'enfant pr�c�dant � la baby sitter
		p.garderEnfant("Josselin", bs);
		// Le status de l'enfant doit �tre "EnfantChezBS"
		AssertEquals(e.getStatus(), "EnfantChezBS");
		// L'enfant ne peut pas aller dormir sans avoir manger
		assertFalse(bs.faireDormirEnfant());
		assertTrue(bs.nourirEnfant());
		AssertEquals(e.getStatus(), "EnfantAMang�");
		// La baby sitter endort l'enfant
		assertTrue(bs.faireDormirEnfant());
		// Le status de l'enfant doit etre pass� "EnfantADormi"
		AssertEquals(e.getStatus(), "EnfantADormi");
		// L'enfant qui a dormi ne peut pas etre nourri
		AssertFalse(bs.nourirEnfant());
		Parent p1 = new Parent("MARY");
		p1.creerEnfant("Laurent");
		// La baby-sitter ne peut avoir en charge qu'un seul enfant
		AssertFalse(p1.garderEnfant("Laurent", bs));
		// les parents p viennent chercher leur enfant
		AssertTrue(p.recupererEnfant("Josselin"));
		// le status de l'enfant repasse � "EnfantChezParent"
		AssertEquals(e.getStatus(), "EnfantChezParent");
		
	}
}

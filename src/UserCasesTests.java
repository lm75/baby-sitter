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
		assertEquals(p.getNombreEnfant(), 1);
		// le status initial de l'enfant est "EnfantChezParent"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezParent);
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
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezParent);
		// On cr�� une baby-Sitter
		BabySitter bs = new BabySitter("Magali");
		// On affecte l'enfant pr�c�dant � la baby sitter
		p.amenerEnfantBS("Josselin", bs);
		// Le statut de l'enfant doit �tre "EnfantChezBS"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezBS);
		// La bs n'est plus disponible
		assertFalse(bs.isDisponible());
	}
	
	public void testBSManageEnfant(){
		Parent p = new Parent("GUILLAUME");
		Enfant e = p.creerEnfant("Josselin");
		BabySitter bs = new BabySitter("Magali");
		p.amenerEnfantBS("Josselin", bs);
		// Le statut de l'enfant doit �tre "EnfantChezBS"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezBS);
		assertFalse(bs.faireDormirEnfant());
		assertTrue(bs.nourrirEnfant());
		assertEquals(e.getStatut(), StatutEnfant.EnfantAMange);
		assertTrue(bs.faireDormirEnfant());
		assertEquals(e.getStatut(), StatutEnfant.EnfantADormi);
		assertFalse(bs.nourrirEnfant());
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
		// On cr�� un parent
		Parent p = new Parent("GUILLAUME");
		// le parent est initialis� sans enfant
		assertEquals(p.getNombreEnfant(),0);
		// les parents cr�� un enfant
		Enfant e = p.creerEnfant("Josselin");
		// Le nombre d'enfant de ces parents passe � 1
		assertEquals(p.getNombreEnfant(), 1);
		// le status initial de l'enfant est "EnfantChezParent"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezParent);
		// On cr�� une baby-Sitter
		BabySitter bs = new BabySitter("Magali");
		// On affecte l'enfant pr�c�dant � la baby sitter
		p.amenerEnfantBS("Josselin", bs);
		// Le statut de l'enfant doit �tre "EnfantChezBS"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezBS);
		// L'enfant ne peut pas aller dormir sans avoir manger
		assertFalse(bs.faireDormirEnfant());
		assertTrue(bs.nourrirEnfant());
		assertEquals(e.getStatut(), StatutEnfant.EnfantAMange);
		// La baby sitter endort l'enfant
		assertTrue(bs.faireDormirEnfant());
		// Le status de l'enfant doit etre pass� "EnfantADormi"
		assertEquals(e.getStatut(), StatutEnfant.EnfantADormi);
		// L'enfant qui a dormi ne peut pas etre nourri
		assertFalse(bs.nourrirEnfant());
		Parent p1 = new Parent("MARY");
		p1.creerEnfant("Laurent");
		// La baby-sitter ne peut avoir en charge qu'un seul enfant
		assertFalse(p1.amenerEnfantBS("Laurent", bs));
		// les parents p viennent chercher leur enfant
		assertTrue(p.recupererEnfant("Josselin", bs));
		// le status de l'enfant repasse � "EnfantChezParent"
		assertEquals(e.getStatut(), StatutEnfant.EnfantChezParent);
	}
	
	/**
	 * JoGui
	 * test : cr�ation de plusieurs enfants d'un parent
	 * Date : 02/03/2015
	 */
	public void testMemeParentPlusieursEnfants(){
		Parent p = new Parent("GUILLAUME");
		Enfant e1 = p.creerEnfant("Josselin");
		assertNull(p.creerEnfant("Josselin"));
		assertNotNull(p.creerEnfant("Anthony"));
	}
	
	/**
	 * JoGui
	 * Deux enfants ne peuvent pas �tre attribu�s � une m�me baby sitter
	 * Date : 02/03/2015
	 */
	public void testEtatToEnfantChezBS(){
		Parent p = new Parent("GUILLAUME");
		Enfant e1 = p.creerEnfant("Josselin");
		BabySitter bs = new BabySitter("Magali");
		p.amenerEnfantBS("Josselin", bs);
		// on test si on ne peut ajouter un deuxi�me enfant � la baby sitter
		Enfant e2 = p.creerEnfant("Anthony");
		assertFalse(p.amenerEnfantBS(e2.getNom(), bs));
	}
	
	/**
	 * JoGui
	 * Les parents peuvent r�cup�rer leur enfant de la baby sitter n'importe quand
	 * Date : 02/03/2015
	 */
	public void testParentRecupereEnfantChaqueEtat(){
		Parent p = new Parent("GUILLAUME");
		Enfant e = p.creerEnfant("Josselin");
		BabySitter bs = new BabySitter("Laurent");
		// On ne peut pas r�cup�rer un enfant qui est d�j� chez ses parents.
		assertFalse(p.recupererEnfant("Josselin", bs));
		p.amenerEnfantBS("Josselin", bs);
		// on peut r�cup�rer l'enfant qu'on vient de confier
		assertTrue(p.recupererEnfant("Josselin", bs));
		// On renvoie l'enfant et la BS le nourit
		p.amenerEnfantBS("Josselin", bs);
		bs.nourrirEnfant();
		// on peut r�cup�rer l'enfant qu'on vient de manger
		assertTrue(p.recupererEnfant("Josselin", bs));
		// On renvoie l'enfant et la BS le nourit et l'endort
		p.amenerEnfantBS("Josselin", bs);
		bs.nourrirEnfant();
		bs.faireDormirEnfant();
		// on peut r�cup�rer l'enfant qui a dormi
		assertTrue(p.recupererEnfant("Josselin", bs));
	}
}


public class EnfantAMange extends StatutEnfant {

	@Override
	public void faireDormirEnfant(Enfant e) {
		e.setStatut(new EnfantADormi());
	}

	@Override
	public void nourrirEnfant(Enfant e) {
		System.err.println("On ne peut pas re-nourrir un enfant");
	}

	@Override
	public void libererEnfant(Enfant e) {
		e.setStatut(new EnfantChezParent());	
	}

	@Override
	public void garderEnfant(Enfant e) {
		System.err.println("On ne peut pas faire garder un enfant qui est déjà chez une baby-sitter");
	}

}


public class EnfantAMange extends StatusEnfant {

	@Override
	public boolean faireDormirEnfant(Enfant e) {
		e.setStatus(new EnfantADormi());
		return false;
	}

	@Override
	public boolean nourrirEnfant(Enfant e) {
		System.err.println("On ne peut pas re-nourrir un enfant");
		return false;
	}

	@Override
	public void libererEnfant(Enfant e) {
		e.setStatus(new EnfantChezParent());	
	}

	@Override
	public void garderEnfant(Enfant e) {
		System.err.println("On ne peut pas faire garder un enfant qui est déjà chez une baby-sitter");
	}

}

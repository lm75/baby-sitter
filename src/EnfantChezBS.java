
public class EnfantChezBS extends StatusEnfant {

	@Override
	public boolean faireDormirEnfant(Enfant e) {
		System.err.println("Un enfant ne peut pas dormir avant d'avoir mangé");
		return false;
	}

	@Override
	public boolean nourrirEnfant(Enfant e) {
		e.setStatus(new EnfantADormi());
		return false;
	}

	@Override
	public void libererEnfant(Enfant e) {
		e.setStatus(new EnfantChezParent());
	}

	@Override
	public void garderEnfant(Enfant e) {
		System.err.println("L'enfant est déjà gardé par la baby-sitter");
	}

}

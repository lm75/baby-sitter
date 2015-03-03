
public class EnfantChezParent extends StatusEnfant {

	@Override
	public boolean faireDormirEnfant(Enfant e) {
		System.err.println("L'enfant ne peut dormir qu'une fois qu'il est chez la baby-sitter");
		return false;
	}

	@Override
	public boolean nourrirEnfant(Enfant e) {
		System.err.println("L'enfant ne peut manger qu'une fois qu'il est chez la baby-sitter");
		return false;
	}

	@Override
	public void libererEnfant(Enfant e) {
		System.err.println("L'enfant ne peut pas être libéré si'il n'est pas chez la baby-sitter");
	}

	@Override
	public void garderEnfant(Enfant e) {
		e.setStatus(new EnfantChezBS());
	}

}

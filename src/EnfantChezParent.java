
public class EnfantChezParent extends StatutEnfant {

	@Override
	public void faireDormirEnfant(Enfant e) {
		System.err.println("L'enfant ne peut dormir qu'une fois qu'il est chez la baby-sitter");
	}

	@Override
	public void nourrirEnfant(Enfant e) {
		System.err.println("L'enfant ne peut manger qu'une fois qu'il est chez la baby-sitter");
	}

	@Override
	public void libererEnfant(Enfant e) {
		System.err.println("L'enfant ne peut pas être libéré si'il n'est pas chez la baby-sitter");
	}

	@Override
	public void garderEnfant(Enfant e) {
		e.setStatut(new EnfantChezBS());
	}

}

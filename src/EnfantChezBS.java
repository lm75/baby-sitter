
public class EnfantChezBS extends StatutEnfant {

	@Override
	public void faireDormirEnfant(Enfant e) {
		System.err.println("Un enfant ne peut pas dormir avant d'avoir mangé");
	}

	@Override
	public void nourrirEnfant(Enfant e) {
		e.setStatut(new EnfantAMange());
	}

	@Override
	public void libererEnfant(Enfant e) {
		e.setStatut(new EnfantChezParent());
	}

	@Override
	public void garderEnfant(Enfant e) {
		System.err.println("L'enfant est déjà gardé par la baby-sitter");
	}
	
	public String toString(){
		return "EnfantChezBS";
	}

}


public class EnfantADormi extends StatusEnfant {

	@Override
	public void libererEnfant(Enfant e) {
		e.setStatus(new EnfantChezParent());
	}

	@Override
	public boolean faireDormirEnfant(Enfant e) {
		System.err.println("On ne peut pas faire dormir un enfant qui a d�j� dormi");
		return false;
	}

	@Override
	public boolean nourrirEnfant(Enfant e) {
		System.err.println("On ne peut pas nourrir un enfant qui a d�j� dormi (et mang�)");
		return false;
	}

	@Override
	public void garderEnfant(Enfant e) {
		System.err.println("On ne peut pas faire garder un enfant qui a d�j� chez la baby-sitter");
	}

}

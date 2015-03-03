
public class EnfantADormi extends StatutEnfant {

	@Override
	public void libererEnfant(Enfant e) {
		e.setStatut(new EnfantChezParent());
	}

	@Override
	public void faireDormirEnfant(Enfant e) {
		System.err.println("On ne peut pas faire dormir un enfant qui a d�j� dormi");
	}

	@Override
	public void nourrirEnfant(Enfant e) {
		System.err.println("On ne peut pas nourrir un enfant qui a d�j� dormi (et mang�)");
	}

	@Override
	public void garderEnfant(Enfant e) {
		System.err.println("On ne peut pas faire garder un enfant qui a d�j� chez la baby-sitter");
	}
	
	public String toString(){
		return "EnfantADormi";
	}

}

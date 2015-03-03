import java.util.Scanner;


public class Main {
	
	public static void main(String []args){
		String nomEnfant;
		String nomParent;
		String nomBS;
		Scanner entree = new Scanner(System.in);
		GestionParent gp = GestionParent.getInstance();
		GestionBabySitter gbs = GestionBabySitter.getInstance();
		while(true)
		{	
			System.out.println("A quelle gestion Parent(Taper p) / Baby-Sitter voulez-vous acc�der ? (Taper b)");
			System.out.println("Pour quitter taper q");
			String reponse =  entree.next();
			if(reponse.equals("p")) {
				// afficher les personnnes et proposer de choisir entre une de ces personnes ou cr�er une nouvelle personne
				gp.listerParent();
				System.out.println("Voulez-vous consulter un parent existant (taper son nom) ou bien creer un nouveau parent (taper c) ou bien revenir au menu principal (taper r) ?");
				reponse = entree.next();
					if( reponse.equals("c") )
					{
						System.out.println("Quel nom voulez-vous donner � votre nouveau parent ?");
						reponse = entree.next();
						 while(! gp.creerParent(reponse)){
							 System.out.println("Le parent "+reponse+" existe d�j�. Merci de donner un autre nom.");
							 reponse = entree.next();
						 }
					} else if ( reponse.equals("r") )
					{
						System.out.println("Retour au menu principal ...");
					} else 
					{
						// nom d'un parent
						Parent p = gp.rechercherParent(reponse);
						nomParent = reponse;
						System.out.println("Vous �tes sur l'�cran de gestion du parent "+reponse);
						// afficher les enfants de ces parents, ou de cr�er un enfant
						System.out.println("Voici la liste des enfants ");
						p.listerEnfants();
						// une fois l'enfant s�lectionn�, proposer de lui affecter une bs ou de le ramener
						System.out.println("Tapez un nom d'enfant ou 'c' pour en cr�er un");
						reponse = entree.next();
						if(reponse.equals("r")){
							System.out.println("Retour au menu principal ...");
						}
						else if(reponse.equals("c")) {
							System.out.println("Tapez un nom d'enfant.");
							reponse = entree.next();
							 while( p.creerEnfant(reponse) == null){
								 System.out.println("L'enfant "+reponse+" existe d�j�. Merci de donner un autre nom.");
								 reponse = entree.next();
							 }
						}
						else {
							Enfant e = p.rechercherEnfant(reponse);
							nomEnfant = reponse;
							if(e.getStatut() instanceof EnfantChezParent){
								System.out.println("Voulez-vous faire garder votre enfant? (Tapez le nom de la baby-sitter) Ou retourner au menu principal (r). Voici les baby-sitter disponibles :");
								gbs.listerBSdisponible();
								reponse = entree.next();
								if(reponse.equals("r")){
									System.out.println("Retour au menu principal ...");
								} else {
									p.amenerEnfantBS(nomEnfant, gbs.rechercherBS(reponse));
								}
							} else{
								System.out.println("Voulez-vous r�cup�rer l'enfant? (o) Ou retourner au menu principal(r)");
								reponse = entree.next();
								if(reponse.equals("r")) {
									System.out.println("Retour au menu principal ...");
								} else {
									p.recupererEnfant(nomEnfant, null);
									System.out.println("L'enfant a �t� r�cup�r�.");
								}
							}
						}
					}
					// si personne, montrer les enfants et proposer d'en cr�er un novueau
					// enfant  - proposer de l'amener chez baby sitter ou de le r�cup�rer
					// proposer toutes les baby sitter dispo , si il n'y en a pas , dire qu'il n'y en a pas et remontrer les parents et leurs enfants
					
			}
			if(reponse.equals("b")){
				gbs.listerBS();
				System.out.println("Voulez-vous consulter une baby-sitter existante (taper son nom) ou bien creer une (taper c) ou bien revenir au menu principal (taper r) ?");
				reponse = entree.next();
					if( reponse.equals("c") )
					{
						System.out.println("Quel nom voulez-vous donner � votre nouvelle baby-sitter ?");
						reponse = entree.next();
						 while(! gbs.creerBS(reponse)){
							 System.out.println("La baby-sitter "+reponse+" existe d�j�. Merci de donner un autre nom.");
							 reponse = entree.next();
						 }
					} else if ( reponse.equals("r")){
						System.out.println("Retour au menu principal ...");
					} else {
						BabySitter bs = gbs.rechercherBS(reponse);
						if(bs.isDisponible()){
							System.out.println("Cette baby-sitter est disponible. Elle n'a pas d'enfant en garde.");
						} else {
							Enfant e = bs.getEnfant();
							System.out.println("La baby-sitter a un enfant : " + e.getNom() + ".");
							System.out.println("Voici son �tat : " + e.getStatut().toString());
							System.out.println("Voici ce que vous pouvez faire : ");
							switch(e.getStatut().toString())
							{
								case "EnfantAMange":
									System.out.println("Le faire dormir. (2)");
									break;
								case "EnfantChezBS":
									System.out.println("Le faire manger. (1)");
									break;
							}
							System.out.println("Ou retourner au menu principal. (r)");
							reponse = entree.next();
							if (reponse.equals("r")){
								System.out.println("Retour au menu principal ...");
							} else if(reponse.equals("1")){
								bs.nourrirEnfant();
							} else {
								bs.faireDormirEnfant();
							}
						}
					}
				// choisir la bs ou en cr�er une autre
					// si bs dispo, le dire et revenir en arriere
					// sinon, proposer les actions possibles
			}
		}
	}
}

package Unite;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println("*********** PROJET JAVA **********************");
		
		Infanterie arme1 = new Infanterie ("Infanterie");
		arme1.Nom_Unite();
		
		Infanterie_lourde arme2 = new Infanterie_lourde ("Infanterie lourde");
		arme2.Nom_Unite();
		
		arme1.Attaque("Foret", 60, arme2);
		arme2.Attaque("Foret", 60, arme1);
		
		
		System.out.println("************************************************");
		
		System.out.println("Dégat causé par armé 1 : " + arme1.getDegat_Brut() );
		System.out.println("Dégat causé par armé 2 : " + arme2.getDegat_Brut() );
		
		System.out.println("************************************************");

		System.out.println("Les points de vies initiaux : ");
		System.out.println("Armé 1 : " + arme1.Point_Vie);
		System.out.println("Armé 2 : " + arme2.Point_Vie);
		
		System.out.println("************************************************");

		System.out.println("Les points de vie causé par dégats bruts : ");
		arme1.Niveau_Vie( arme2.getDegat_Brut() );
		arme2.Niveau_Vie( arme1.getDegat_Brut() );
		
		System.out.println("************************************************");

		System.out.println("Les points de vie causé par dégats net : ");
		arme1.Niveau_Vie( arme2.getDegat() );
		arme2.Niveau_Vie( arme1.getDegat() );
		
		System.out.println("************************************************");
		
		System.out.println("Regeneration des unités : ");
		arme1.Recuperer(arme1);
		arme2.Recuperer(arme2);
	
	
	}

}

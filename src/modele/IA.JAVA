class IA extends Player {

  public Unite Random(){
  
	 liste_Unite L	// Liste_Unité (Archer, Infanterie, Infanterie_Lourde, Mage, Cavalerie)
	 Unite U
 	   int i = (int)(Math.Random()*5);
    
   	 L.get(i);
    
   	 U =  L.get(i); // (Unite Choisir par IA)
    
    
  }


public int choix_IA(String terrain, int Bonus_Defense, Unite unite,int p){

	int i = (int)(Math.Random()*10);
	if (i<3 || i>8) {
	return Attaque(terrain,Bonus_Defense,unite);
	}else{
	return Se_Deplace(terrain,p);

	}
}



}



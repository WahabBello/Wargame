package wargame;

public abstract class Joueur {
	public string nom;
	public int numero; 
	public string couleur; 
	public Arraylist<Unite> liste_unite = new Arraylist<Unite>(); 
	public int nb_unite; 
	public boolean vainquer ; 
	
	
	public Joueur() {
		// TODO Auto-generated constructor stub
	}

}
public void Ajouter_des_unites(){ 
    nombre_dunite++;
    Unite u = new Unite();
    liste_unite.Add(u); 
} 
public int Calculer_score(){
    int sum = 0;
for(int i=0;i<liste_unite.size();i++){
sum+=(liste_unite.Get(i).Poin_Attaques - liste_unite.Get(i).Deffences )+(liste_unite.Get(i).Poin_Deplacement_Max - liste_unite.Get(i).Poin_Deplacement_Restant)+liste_unite.Get(i).Poin_vie_restant;
}
return sum;
}

 







package bioseq;

import java.util.*;

public class Analyser {
	
	public Analyser() {}
	
	public void printFastaSequences(String fichier){
		String sequence = new Sequence(fichier).getSequence();
		System.out.println(sequence);
	}
	
	@SuppressWarnings("resource")
	public void printFastaStats(String fichier){
		String sequence = new Sequence(fichier).getSequence();
		String name = new Sequence(fichier).getName();
		Scanner scanSeq = new Scanner(sequence);
		Scanner scanName = new Scanner(name);
		while(scanName.hasNextLine()){
			System.out.println(scanName.nextLine() + " " + scanSeq.nextLine().length());
		}
	}
	
	public void listKmers(int longueur, String fichier){
		ArrayList<String> list = new Kmers(longueur, fichier).getList();
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	public void commonKmers(int longueur, String fichier1, String fichier2){
		Kmers kmers1 = new Kmers(longueur, fichier1);
		Kmers kmers2 = new Kmers(longueur, fichier2);
		kmers1.deleteDoublon();
		kmers2.deleteDoublon();
		ArrayList<String> list1 = kmers1.getList();
		ArrayList<String> list2 = kmers2.getList();
		for(int i = 0; i < list1.size(); i++){
			for(int j = 0; j < list2.size(); j++){
				if(list1.get(i).equals(list2.get(j))){
					System.out.println(list1.get(i));
				}
			}
		}
	}
	
	/**
	 * @param longueur 
	 * 			la longueur d'un kmer
	 * @param fichier1
	 * @param fichier2
	 * @return la proportion de kmers du premier fichier qui sont présent dans le deuxième
	 */
	public double ratio_common_kmers (int longueur, String fichier1, String fichier2) {
		Kmers kmers1 = new Kmers(longueur, fichier1);
		Kmers kmers2 = new Kmers(longueur, fichier2);
		double nombreTotalKmers2 = kmers2.getList().size();
		// On initialise le compteur pour connaitre le nombre de kmers du fichier 1 qui est présent dans le fichier 2
		double nombreDeKmers1Dans2 = 0;
		// On supprime les doublons du deuxième fichier pour éviter de comparer deux fois
		kmers2.deleteDoublon();
		
		ArrayList<String> list1 = kmers1.getList();
		ArrayList<String> list2 = kmers2.getList();		
		
		// On effectue les comparaisons et on incrémente le compteur
		for(int i = 0; i < list1.size(); i++){
			for(int j = 0; j < list2.size(); j++){
				if(list1.get(i).equals(list2.get(j))){
					nombreDeKmers1Dans2++;
				}
			}
		}
		
		// calcul de la proportion : nombre de présent du fichier1 / nombre total de kmer du fichier2
		return nombreDeKmers1Dans2 / nombreTotalKmers2;
	}
	
	/**
	 * Réponse à la question 9 : 
	 *  Lorsque que l'on compare les 4-mers d'ebola-z et d'ebola-t on obtient un ratio de 0,998. Cela montre que
	 *  la séquence de ces deux virus est très proche, ainsi ils font parti de la même catégorie de virus. 
	 *  Mais lorsque que l'on augmente la taille des kmers (longueur 8 par exemple), ce ratio diminue fortement. 
	 *  Ceci montre que les différences entre les deux virus se trouvent en milieu de séquence et non aux extrémités.
	 *  
	 *  On trouve un ratio de 0,39 lorsque l'on compare ebola-z et phage lambda. Cela montre que ces deux virus 
	 *  appartiennent à des catégories différentes mais présente certaines séquences en commun.
	 */
	
	
}

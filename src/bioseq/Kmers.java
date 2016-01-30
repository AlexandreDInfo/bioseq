package bioseq;

import java.util.*;

/**
 * @author Delassus Alexandre
 * @author Merciert Tony
 * Représente le K-mers sous forme de Liste pour permettre un meilleur traitement des données.
 */
public class Kmers {

	private ArrayList<String> list;
	/**
	 * Constructeur de K-mers
	 * @param longueur
	 * 			la longueur d'un k-mers
	 * @param fichier
	 */
	public Kmers(int longueur, String fichier){
		this.list = new ArrayList<String>();
		this.generateKmers(longueur, fichier);
	}
	/**
	 * Getter de list
	 * @return list
	 */
	public ArrayList<String> getList(){
		return this.list;
	}
	/**
	 * Ajoute le k-mers à la liste des k-mers
	 * @param kmers
	 */
	public void addKmers(String kmers){
		this.list.add(kmers);
	}
	/**
	 * Transforme un fichier fasta en liste de K-mers
	 * @param longueur
	 * 			la longueur d'un K-mers
	 * @param fichier
	 */
	@SuppressWarnings("resource")
	public void generateKmers(int longueur, String fichier){
		String sequence = new Sequence(fichier).getSequence();
		Scanner scan = new Scanner(sequence);
		/* Tant qu'il reste une ligne de sequence,
		 * On ajoute tous les K-mers de cette sequence */
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			for(int i = 0; i <= (line.length() - longueur); i++){
				this.addKmers(line.substring(i, i + longueur));
			}
		}
	}
	/**
	 * Enleve les doublons de la liste de k-mers
	 */
	public void deleteDoublon(){
		/* On passe la liste en set pour enlever les doublons puis on la repasse en liste */
        Set<String> set = new HashSet<String>();
        set.addAll(this.list);
        this.list = new ArrayList<String>(set) ;
	}
	
}

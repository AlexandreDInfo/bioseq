package bioseq;

import java.util.*;

public class Kmers {

	private ArrayList<String> list;
	
	public Kmers(int longueur, String fichier){
		this.list = new ArrayList<String>();
		this.generateKmers(longueur, fichier);
	}
	
	public ArrayList<String> getList(){
		return this.list;
	}
	
	public void addKmers(String kmers){
		this.list.add(kmers);
	}
	
	@SuppressWarnings("resource")
	public void generateKmers(int longueur, String fichier){
		String sequence = new Sequence(fichier).getSequence();
		Scanner scan = new Scanner(sequence);
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			for(int i = 0; i <= (line.length() - longueur); i++){
				this.addKmers(line.substring(i, i + longueur));
			}
		}
	}
	
	public void deleteDoublon(){
        Set<String> set = new HashSet<String>();
        set.addAll(this.list);
        this.list = new ArrayList<String>(set) ;
	}
	
}

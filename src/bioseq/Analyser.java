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
}

package bioseq;

/**
 * @author Delassus Alexandre
 * @author Merciert Tony
 * Classe main de bioseq
 */
public class Main {
	/**
	 * Main permettant d'utiliser la bonne fonction par rapport à l'option ecrite
	 * @param args
	 */
	public static void main (String[] args){
	    String option = args[0];
	    Analyser analyser = new Analyser();
	    /* On examine l'option et on utilise la bonne fonction */
	    if(option.equals("print-fasta-sequences")){
	    	analyser.printFastaSequences(args[1]);
	    }
	    if(option.equals("print-fasta-stats")){
	    	analyser.printFastaStats(args[1]);
	    }
	    if(option.equals("list-kmers")){
	    	analyser.listKmers(Integer.parseInt(args[1]), args[2]);
	    }
	    if(option.equals("common-kmers")){
	    	analyser.commonKmers(Integer.parseInt(args[1]),args[2], args[3]);
	    }
	    if(option.equals("ratio-common-kmers")){
	    	System.out.println(analyser.ratio_common_kmers(Integer.parseInt(args[1]), args[2], args[3]));
	    }
	    if(option.equals("random-mutations")){
	    	System.out.println(analyser.random_mutations(Integer.parseInt(args[1]), args[2]));
	    }
	}
}

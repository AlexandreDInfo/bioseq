package bioseq;

import java.io.*;
import java.util.*;

public class Sequence {
	
	private String sequence;
	private String name;
	
	public Sequence(String fichier){
		this.generateSequence(fichier);
		this.generateName(fichier);
	}
	
	public void generateSequence(String fichier){
		
		Scanner scanner;
		boolean init = false;
		this.sequence = "";
		try {
			scanner = new Scanner(new File(fichier));
			while (scanner.hasNextLine()) {
			    String line = scanner.nextLine();
			    if(line.charAt(0) == '>'){
			    	if(init)
			    		this.sequence += '\n';
			    }
			    else{
			    	this.sequence += line;
			    }
			    init = true;
			}
			 
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		}
	}
	
	public void generateName(String fichier){
		Scanner scanner;
		this.name = "";
		try {
			scanner = new Scanner(new File(fichier));
			while (scanner.hasNextLine()) {
			    String line = scanner.nextLine();
			    if(line.charAt(0) == '>'){
			    	name += line.substring(1);
			    	name += '\n';
			    }
			}
			scanner.close();
		} catch (FileNotFoundException e) {}
	}
	
	public String getSequence(){
		return this.sequence;
	}
	public String getName(){
		return this.name;
	}
}

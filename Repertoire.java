/* Classe qui permet de retourner tous les ficheir portant l'extension ext d'un fichier */

import java.io.File;

class Repertoire{
	
	private String [] listefichiers; 
	private String extension;
	private String [] fichiers;
	
	public Repertoire(){
		extension = new String(".csv");
		fichiers = new String[20];
		listefichiers = new String[20];
	}
	
	public Repertoire(String ext){
		extension = new String(ext);
		fichiers = new String[20];
		listefichiers = new String[20];
	}
	
	public void listerRepertoire(File repertoire){ 
		
		listefichiers = repertoire.list(); 
		int j = 0;
		for(int i = 0; i < listefichiers.length; i++){ 
			if(listefichiers[i].endsWith(extension)){ 
				fichiers[j] = new String(listefichiers[i]); 
				j++;
			} 
		} 
	}
	
	public String[] getFichier(){
		
		return fichiers;
		
	}
	
}

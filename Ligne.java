/* Classe qui permet d'avoir le nombre de ligne d'un fichier CSV grâce a la méthode Geti ainsi que son contenu*/

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.File;
import java.io.*;

class Ligne{
	
	private int i;
	private String[] contenu;
	
	public Ligne() throws IOException{
	
		FileReader fr = null;
		LineNumberReader lnr = null;
		String str;
		
      
		try{
			
			fr = new FileReader("C:/test.txt");
			lnr = new LineNumberReader(fr);
   
			
			while((str=lnr.readLine())!=null)
			{
				i=lnr.getLineNumber();
				System.out.print("("+i+")");
                  
				
				System.out.println(str);
			}
		}catch(Exception e){
         
        
        e.printStackTrace();
		}finally{
         
			
			if(fr!=null)
				fr.close();
			if(lnr!=null)
				lnr.close();
      }	
	}
	
	public Ligne(String fichier) throws IOException{
	
		FileReader fr = null;
		LineNumberReader lnr = null;
		String str;
		
		try{
			
			fr = new FileReader(new File(fichier));
			lnr = new LineNumberReader(fr);
			contenu = new String[100];
			
			while((str=lnr.readLine())!=null)
			{
				i=lnr.getLineNumber();
				System.out.print("("+i+")");
                  
				contenu[i - 1] = new String(str);
				  
				
				System.out.println(str);
			}
		}catch(Exception e){
         
        
        e.printStackTrace();
		}finally{
         
			
			if(fr!=null)
				fr.close();
			if(lnr!=null)
				lnr.close();
      }	
	}
	
	public int Geti(){ // retourne le nombre de ligne d'un fichier
		return i;
	}
	
	public String GetContenu(int i){
		
		return contenu[i];
		
	}
	
}
/*import javax.swing;*/
import javax.swing.JList;
import javax.swing.*;
import java.io.*; 
import javax.swing.JCheckBox;

class Centre{
	
	private Ligne l;
	private JCheckBox[] box; 
	
	public Centre(){

		 
		try{
		  l = new Ligne("C:/Users/yazid/Desktop/projetjava/wallyn.csv");
		}catch(IOException e){
		  e.printStackTrace();
		}
		
		box = new JCheckBox[l.Geti()];
		
		for(int i = 0; i < l.Geti(); i++){
			box[i] = new JCheckBox(l.GetContenu(i));
			box[i].setBounds(150, 200 + (i * 30) , 300, 30);
		}

	}
	
	public Centre(String fichier){

		 
		try{
		  l = new Ligne(fichier);
		}catch(IOException e){
		  e.printStackTrace();
		}
		
		box = new JCheckBox[l.Geti()];
		
		for(int i = 0; i < l.Geti(); i++){
			box[i] = new JCheckBox(l.GetContenu(i));
			box[i].setBounds(150, 200 + (i * 30) , 300, 30);
		}

	}
	
	public void charger(String fichier){
		
		try{
		  l = new Ligne(fichier);
		}catch(IOException e){
		  e.printStackTrace();
		}
		
		box = new JCheckBox[l.Geti()];
		
		for(int i = 0; i < l.Geti(); i++){
			box[i] = new JCheckBox(l.GetContenu(i));
			box[i].setBounds(225, 215 + (i * 25) , 500, 30);
		}	
		
	}
	
	public JCheckBox GetCheck(int i){
		return box[i];
	}
	
	public int Gi(){
		
		return l.Geti();
		
	}


}

import java.awt.Graphics;
import javax.swing.JPanel; 
import javax.swing.JCheckBox;
import java.util.ArrayList;
import java.awt.ItemSelectable;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.print.Book;
import java.awt.print.Paper;
import javax.swing.JTextField;



public class Panneau extends JPanel implements ActionListener{ 

	private Bout sel; // bouton selection
	private Bout tous; // bouton tous
	private LstD ldc; // liste déroulante csv
	private Centre c;
	private Ligne l;
	private Label label;
	private JLabel image_cote;
	private JLabel background;
	private JTextField largeur, hauteur;
	
	
	public Panneau(){
		sel = new Bout("Imprimer selection", 150, 500, 150, 35);
		tous = new Bout("Imprimer tout", 350, 500, 150, 35);
		
		largeur = new JTextField("6");
		hauteur = new JTextField("4");
		
		largeur.setBounds(425, 145, 250, 35);
		hauteur.setBounds(425, 180, 250, 35);
		
		sel.addActionListener(this);
		tous.addActionListener(this);
		
		c = new Centre();
		
		ldc = new LstD(".csv", 425, 100, 250, 35);
		
		label = new Label("Veuillez selectionner le type de fichier .csv");
		label.setBounds(330, 30, 250, 100);
		
		/*Images*/
		 image_cote = new JLabel( new ImageIcon("cote.png"));
		 image_cote.setBounds(10, 10, 285, 140);
		 
		 background = new JLabel( new ImageIcon("BG.png"));
		 background.setBounds(0, 5, 820, 600);
		 
		 
		/********/
		setBackground(Color.WHITE);
		ldc.addItemListener(new ItemListener(){
			
			public void itemStateChanged(ItemEvent e){
				
				if(e.getStateChange() == ItemEvent.SELECTED){
					System.out.println("Ayo");
					
					for(int i = 0; i < c.Gi(); i++){
						remove(c.GetCheck(i));
					}
					
					Path currentRelativePath = Paths.get("");
					
					c.charger(currentRelativePath.toAbsolutePath().toString() + "/" + e.getItem());
					
					
					
					for(int i = 0; i < c.Gi(); i++){
						c.GetCheck(i).setBackground(Color.WHITE);
						add(c.GetCheck(i));
					}
					
					revalidate();
					repaint();
				}
				
			}
			
		});
		
		
		
		ldc.ajouter_element();
		
		setLayout(null);

		add(background);
		add(sel);
		add(tous);
		add(ldc);
		add(image_cote);
		add(label);
		add(largeur);
		add(hauteur);
		

		
		for(int i = 0; i < c.Gi(); i++){
			add(c.GetCheck(i));
		}
		

	}   

		public void actionPerformed(ActionEvent e){
			Object source = e.getSource();
			
			if (source == sel){
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(new File("tmp.csv")));
					
					for(int i = 0; i < c.Gi(); i++){
						
						if(c.GetCheck(i).isSelected()){
							writer.write(c.GetCheck(i).getText());
							writer.write("\n");
						}
					}
					writer.close();
				}
				catch (IOException f)
				{
					f.printStackTrace();
				}
				
								  // Récupère un PrinterJob
					PrinterJob job = PrinterJob.getPrinterJob();
				  // Définit son contenu à imprimer
				  job.setPrintable(new Imprimer(Integer.parseInt(hauteur.getText()), Integer.parseInt(largeur.getText())));
				  // Affiche une boîte de choix d'imprimante
				  
				  /*****************/
				  
				  
				  
				  
				  /*****************/
				  
				  
				  if (job.printDialog()){
					 try {
						// Effectue l'impression
						job.print();
					 } catch (PrinterException ex) {
						ex.printStackTrace();
					 }
				  } 
			}
			else if (source == tous){
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(new File("tmp.csv")));
					
					for(int i = 0; i < c.Gi(); i++){
						writer.write(c.GetCheck(i).getText());
						writer.write("\n");
					}
					writer.close();
				}
				catch (IOException f)
				{
					f.printStackTrace();
				}
				
								  // Récupère un PrinterJob
				  PrinterJob job = PrinterJob.getPrinterJob();
				  // Définit son contenu à imprimer
				  job.setPrintable(new Imprimer(Integer.parseInt(hauteur.getText()), Integer.parseInt(largeur.getText())));
				  // Affiche une boîte de choix d'imprimante
				  if (job.printDialog()){
					 try {
						// Effectue l'impression
						job.print();
					 } catch (PrinterException ex) {
						ex.printStackTrace();
					 }
				  } 
			}
		}	
}

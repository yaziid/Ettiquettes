import java.awt.Color;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.FontMetrics;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.print.Paper;
import java.awt.print.Book;
import java.awt.Toolkit;

public class Imprimer implements Printable{
	
	private int largeur;
	private int hauteur;
	
	public Imprimer(int h, int l){
		largeur = l;
		hauteur = h;
	}
	
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

	/*
					Paper paper = pageFormat.getPaper();
					paper.setSize(100.0, 100.0);
					//paper.setImageableArea(0.5 * 72, 0.0 * 72, 7.5 * 72, 10.5 * 72);
					pageFormat.setPaper(paper); */
		Ligne l;
		int nblignes = 0;
		String[][] slit = null;
		try{
		  l = new Ligne("tmp.csv");
		  nblignes = l.Geti();
		  slit = new String[nblignes][];
		}catch(IOException e){
		  e.printStackTrace();
		}
		
		String chaine="";
		
		//lecture du fichier texte	
		try{
			InputStream ips = new FileInputStream("tmp.csv"); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			int i = 0;
			while ((ligne=br.readLine())!=null){
				System.out.println(ligne + "to");
				slit[i] = ligne.split(";");
				i++;
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
			System.out.println("Slit " + slit[0][0]);
			double width = largeur;
			double height = hauteur;
		
			if(pageIndex < nblignes){ // on imprime
				/*
				double xLeft  = pageFormat.getImageableX();
				double yTop   = pageFormat.getImageableY();
				double width  = pageFormat.getImageableWidth();
				double height = pageFormat.getImageableHeight();*/
				
				for(int i = 0; i < 6; i++){ // le nombre de point virgule
				

						Paper custom = new Paper();
						custom.setSize((width*0.39)*72.0,(height*0.39)*72.0);
						custom.setImageableArea(0,0,custom.getWidth(), custom.getHeight());
						pageFormat.setPaper(custom);
						
						System.out.println("largeur: "+pageFormat.getImageableWidth()+" hauteur: "+pageFormat.getImageableHeight());
						
						/*Center le text*/
						int w = (int)pageFormat.getImageableWidth();
						int h = (int)pageFormat.getImageableHeight();
						FontMetrics fm = graphics.getFontMetrics();
						int xCentre = (w - fm.stringWidth(slit[pageIndex][i])) / 2;
						int yCentre = ((fm.getAscent() + h - (fm.getAscent() + fm.getDescent())) / 2);

							//System.out.println(Toolkit.getDefaultToolkit().getScreenResolution());
							graphics.drawRect(0, 0, (int)((custom.getWidth()/72)*2.54), (int)((custom.getHeight()/72)*2.54));
				
					switch(i){
						case 0: graphics.drawString(slit[pageIndex][i], 0, 0); break; // modification de position ici sur le slit[][]
						case 1: graphics.drawString(slit[pageIndex][i], 0, yCentre - (yCentre/2)); break;// modification de position ici sur le slit[][]
						case 2: graphics.drawString(slit[pageIndex][i], 0, yCentre); break;// modification de position ici sur le slit[][]
						case 3: graphics.drawString(slit[pageIndex][i], 0, yCentre + (yCentre / 4)); break;// modification de position ici sur le slit[][]
						case 4: graphics.drawString(slit[pageIndex][i], 0, yCentre + (yCentre / 2)); break;// modification de position ici sur le slit[][]
						case 5: graphics.drawString(slit[pageIndex][i], 0, yCentre + yCentre); break;// modification de position ici sur le slit[][]
						default: System.out.println("Error !");
					}
					
				}
				
				System.out.println("t" + pageIndex);
				
				return Printable.PAGE_EXISTS;
			} 
		
			return Printable.NO_SUCH_PAGE;
	}
	/*
	public static void main(String[] args){
		
      // Récupère un PrinterJob
      PrinterJob job = PrinterJob.getPrinterJob();
      // Définit son contenu à imprimer
      job.setPrintable(new Imprimer());
      // Affiche une boîte de choix d'imprimante
      if (job.printDialog()){
         try {
            // Effectue l'impression
            job.print();
         } catch (PrinterException ex) {
            ex.printStackTrace();
         }
      } 
	  
	  
		
		
	}*/
}

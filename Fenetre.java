import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	private Panneau pan;
	private Repertoire r;
	
	public Fenetre(){
		
		super();
		this.setTitle("Kurdy");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		
		pan = new Panneau();
		
		this.setContentPane(pan); 
		setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		
		Fenetre t = new Fenetre();
		
	}
	
}
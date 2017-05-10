import javax.swing.JComboBox;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

class LstD extends JComboBox{
	
	private Repertoire r;
	private String [] t;
	
	public LstD(){
		
		super();
		r = new Repertoire();
		
	}
	
	public LstD(String ext, int x , int y, int w, int h){
		
		super();
		setBounds(x, y, w, h);
		r = new Repertoire(ext);
		
	}
	
	public void ajouter_element(){
		t = new String[20];
		Path currentRelativePath = Paths.get("");
		r.listerRepertoire(new File(currentRelativePath.toAbsolutePath().toString()));
		
		t = r.getFichier();
		
		for(int i = 0; i < t.length; i++){
			addItem(t[i]);
		}

		r.getFichier();
	}
	
	public String getT(int i){
		return t[i];
		
	}
	
}

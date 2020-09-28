package InterfazGrafica;

import javax.swing.JOptionPane;

public class MAIN {

	public static void main(String[] args) {
		
	mensaje("La competencia no esta planificada o en disputa ", "Error");	 
		

	}
	
	
	
	public static void mensaje(String error,String titulo){
        if(JOptionPane.showConfirmDialog(null,
            error, titulo
            , JOptionPane.PLAIN_MESSAGE
            , JOptionPane.ERROR_MESSAGE)==0);
    }
	

}

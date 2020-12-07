package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;

public class VentanaAdmin extends JFrame {

	public static JPanel contentPane;
	
	public static PntVerCompetencia pntVerCompetencia= new PntVerCompetencia();
	public static PntVerEncuentros pntVerEncuentro= new PntVerEncuentros();
	public static PntInicio inicio= new PntInicio();
	public static PntLogin login= new PntLogin();
	public static PntCrearCompetencia pntCrearCompetencia = new PntCrearCompetencia();
	public static PntCrearEliminatoria pntCrearEliminatoria= new PntCrearEliminatoria();
	public static PntCrearLiga pntCrearLiga= new PntCrearLiga();
	public static PntListarParticipantes pntListarParticipantes= new PntListarParticipantes();
	public static PntAltaParticipante pntAltaParticipante = new PntAltaParticipante();
	public static PntListarCompetencias pntListarCompetencias = new PntListarCompetencias();
	
	private static Dimension sizePnt;
	private static CardLayout cl= new CardLayout();
	
	public static String n_pntCrearCompetencia = "n_pntCrearCompetencia";
	public static String n_pntCrearEliminatoria= "n_pntCrearEliminatoria";
	public static String n_pntCrearLiga= "n_pntCrearLiga";
	public static String n_pntListarParticipantes= "n_pntListarParticipantes";
	public static String n_pntAltaParticipante ="n_pntAltaParticipante";
	public static String n_pntListarCompetencias = "n_pntListarCompetencias";
	public static String n_pntVerCompetencia = "n_pntVerCompetencia";
	public static String n_pntVerEncuentros = "n_verEncuentros";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdmin frame = new VentanaAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setTitle("SPORTsYSTEM");
		contentPane.setLayout(cl); // pasa al contentPane el CardLayout que creamos
	
		sizePnt = contentPane.getSize() ;
		
		contentPane.add(n_pntCrearCompetencia, pntCrearCompetencia);
		contentPane.add(n_pntCrearEliminatoria, pntCrearEliminatoria);
		contentPane.add(n_pntCrearLiga, pntCrearLiga);
		contentPane.add(n_pntListarParticipantes, pntListarParticipantes);
		contentPane.add(n_pntAltaParticipante, pntAltaParticipante);
		contentPane.add(n_pntListarCompetencias, pntListarCompetencias);
		contentPane.add(n_pntVerCompetencia, pntVerCompetencia);
		contentPane.add(n_pntVerEncuentros, pntVerEncuentro);
		
		//cambiarPantalla(pntCrearCompetencia, n_pntCrearCompetencia);
		//cambiarPantalla(pntCrearLiga, n_pntCrearLiga);
		//cambiarPantalla(pntCrearEliminatoria, n_pntCrearEliminatoria);
		cambiarPantalla(pntListarCompetencias, n_pntListarCompetencias);
	
	}
	
	public static void cambiarPantalla(JPanel panel, String nombrePnt) {
		panel.setSize(sizePnt);
		cl.show(contentPane, nombrePnt); // show: muestra esa Pnt en ese contenedor
		contentPane.revalidate(); // "limpiar el contenedor o VentanaAdmin"
		contentPane.repaint(); // "repintar el contenedor"		
	}
	
	
	//Ventana emergente de error
	public static void mensajeError(String error, String titulo) {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(null, error, titulo, 
			JOptionPane.PLAIN_MESSAGE, 
			JOptionPane.ERROR_MESSAGE)==0);
	}
	
	//Ventana emergente de consulta
	public static int mensajeConsulta(String[] args, String titulo, String mensaje) {
        int seleccion = JOptionPane.showConfirmDialog(null,
                mensaje, titulo,JOptionPane.YES_NO_OPTION);
	// 0=yes, 1=no
	System.out.println(seleccion);
	return seleccion;
    }
	
	//Ventana emergente de confirmacion
	public static void mensajeExito(String texto, String titulo) {
		if (JOptionPane.showConfirmDialog(null, texto, titulo, JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE)==0);
	}
	
	
	public static void administrarExcepcion (String msj) {
		
		int error = Integer.parseInt(msj);
		
		switch (error) {
		
		case 1: 
			mensajeError("Campo 'Nombre Competencia' vacio", "ERROR");
			cambiarPantalla(VentanaAdmin.pntCrearCompetencia,VentanaAdmin.n_pntCrearCompetencia);
		break;
		
		case 2: 
			mensajeError("No existen disponibilidades cargadas", "ERROR");
			cambiarPantalla(VentanaAdmin.pntCrearCompetencia,VentanaAdmin.n_pntCrearCompetencia);
		break;
		
		case 3: 
			mensajeError("Campo 'Puntos por partido ganado' vacío", "ERROR");
		break;
		
		case 4: 
			 mensajeError("Campo 'Puntos por presentarse' vacío", "ERROR");
		break;
		
		case 5:
			mensajeError("Campo 'Puntos por partido empatado' vacío", "ERROR");
		break;
		
		case 6: 
			mensajeExito("Competencia creada correctamente", "ÉXITO");
		break;
		
		case 7: 
			mensajeError("El nombre del participante ya existe en esta competencia", "ERROR");
		break;
		
		case 8:
			mensajeError("El correo ya esta ascociado a otro participante", "ERROR");
		break;
		
		case 9: 
			mensajeExito("¡Participante Registrado!", "ÉXITO");
			VentanaAdmin.cambiarPantalla(VentanaAdmin.pntListarParticipantes, VentanaAdmin.n_pntListarParticipantes);
		break;
		
		case 10:
			mensajeError("La competencia se encuentra Finalizada", "ERROR");
		break;

		case 11:
			mensajeError("La competencia se encuentra En Disputa", "ERROR");
		break;
		
		case 12:
			mensajeError("No hay suficientes disponibilidades para la cantidad de encuentros a disputar por fase.", "ERROR");
		break;
		
		case 13:
			mensajeExito("Fixture generado con éxito", "ÉXITO");
		break;
		
		}
		
	}
	
	
	
}
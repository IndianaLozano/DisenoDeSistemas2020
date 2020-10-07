package InterfazGrafica;

import javax.swing.JPanel;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Button;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButtonMenuItem;

public class PntCrearLiga extends JPanel {
	private JTextField tf_puntospg;
	private JTextField tf_puntope;
	private JTextField tf_puntospp;

	/**
	 * Create the panel.
	 */
	public PntCrearLiga() {
		setPreferredSize(new Dimension(730, 460));
		setLayout(null);
		
		Label crearNuevaCompetenciaDeportiva = new Label();
		crearNuevaCompetenciaDeportiva.setText(" CREAR NUEVA COMPETENCIA DEPORTIVA");
		crearNuevaCompetenciaDeportiva.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crearNuevaCompetenciaDeportiva.setBounds(188, 20, 401, 24);
		add(crearNuevaCompetenciaDeportiva);
		
		Label crearNuevaCompetenciaDeportiva_1 = new Label();
		crearNuevaCompetenciaDeportiva_1.setText(" SISTEMA DE LIGA: FORMA DE PUNTUACI\u00D3N");
		crearNuevaCompetenciaDeportiva_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		crearNuevaCompetenciaDeportiva_1.setBounds(199, 50, 358, 24);
		add(crearNuevaCompetenciaDeportiva_1);
		
		JLabel crearNuevaCompetenciaPuntuacionLiga_1_1_2 = new JLabel();
		crearNuevaCompetenciaPuntuacionLiga_1_1_2.setText(" PUNTOS POR PARTIDO GANADO(*)");
		crearNuevaCompetenciaPuntuacionLiga_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		crearNuevaCompetenciaPuntuacionLiga_1_1_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		crearNuevaCompetenciaPuntuacionLiga_1_1_2.setBounds(73, 129, 207, 19);
		add(crearNuevaCompetenciaPuntuacionLiga_1_1_2);
		
		tf_puntospg = new JTextField();
		tf_puntospg.setColumns(10);
		tf_puntospg.setBounds(285, 128, 49, 19);
		add(tf_puntospg);
		
		JCheckBox chb_empatepermitido = new JCheckBox("EMPATE PERMITIDO");
		chb_empatepermitido.setFont(new Font("Calibri", Font.PLAIN, 14));
		chb_empatepermitido.setBounds(73, 197, 157, 23);
		add(chb_empatepermitido);
		
		JLabel crearNuevaCompetenciaPuntuacionLiga_1_1 = new JLabel();
		crearNuevaCompetenciaPuntuacionLiga_1_1.setText(" PUNTOS POR PARTIDO EMPATADO");
		crearNuevaCompetenciaPuntuacionLiga_1_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		crearNuevaCompetenciaPuntuacionLiga_1_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		crearNuevaCompetenciaPuntuacionLiga_1_1.setBounds(73, 221, 207, 19);
		add(crearNuevaCompetenciaPuntuacionLiga_1_1);
		
		tf_puntope = new JTextField();
		tf_puntope.setColumns(10);
		tf_puntope.setBounds(285, 220, 49, 19);
		add(tf_puntope);
		
		JLabel crearNuevaCompetenciaPuntuacionLiga_1_1_1 = new JLabel();
		crearNuevaCompetenciaPuntuacionLiga_1_1_1.setText(" PUNTOS POR PRESENTARSE(*)");
		crearNuevaCompetenciaPuntuacionLiga_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		crearNuevaCompetenciaPuntuacionLiga_1_1_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		crearNuevaCompetenciaPuntuacionLiga_1_1_1.setBounds(73, 293, 207, 19);
		add(crearNuevaCompetenciaPuntuacionLiga_1_1_1);
		
		tf_puntospp = new JTextField();
		tf_puntospp.setColumns(10);
		tf_puntospp.setBounds(254, 292, 49, 19);
		add(tf_puntospp);
		
		Button btn_atras = new Button("Atr\u00E1s");
		btn_atras.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_atras.setBounds(62, 372, 70, 22);
		add(btn_atras);
		
		Button btn_siguiente = new Button("Siguiente");
		btn_siguiente.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_siguiente.setBounds(590, 372, 70, 22);
		add(btn_siguiente);
		
		JLabel crearNuevaCompetenciaPuntuacionLiga_1 = new JLabel();
		crearNuevaCompetenciaPuntuacionLiga_1.setText(" FORMA DE PUNTUACI\u00D3N:");
		crearNuevaCompetenciaPuntuacionLiga_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		crearNuevaCompetenciaPuntuacionLiga_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		crearNuevaCompetenciaPuntuacionLiga_1.setBounds(402, 128, 287, 19);
		add(crearNuevaCompetenciaPuntuacionLiga_1);
		
		JRadioButton rb_sets = new JRadioButton("SETS");
		rb_sets.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		rb_sets.setBounds(413, 150, 62, 23);
		add(rb_sets);
		
		JComboBox cb_cantidadsets = new JComboBox();
		cb_cantidadsets.setModel(new DefaultComboBoxModel(new String[] {"Cantidad de sets"}));
		cb_cantidadsets.setFont(new Font("Calibri", Font.PLAIN, 14));
		cb_cantidadsets.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cb_cantidadsets.setAlignmentX(0.0f);
		cb_cantidadsets.setBounds(481, 151, 139, 20);
		add(cb_cantidadsets);
		
		JRadioButton rb_puntuacion = new JRadioButton("PUNTUACI\u00D3N");
		rb_puntuacion.setBounds(413, 194, 127, 23);
		add(rb_puntuacion);
		
		JComboBox cb_tantosausenciarival = new JComboBox();
		cb_tantosausenciarival.setModel(new DefaultComboBoxModel(new String[] {"Tantos ganados por ausencia del rival"}));
		cb_tantosausenciarival.setFont(new Font("Calibri", Font.PLAIN, 14));
		cb_tantosausenciarival.setBounds(413, 218, 247, 19);
		add(cb_tantosausenciarival);
		
		JRadioButton rb_resultado_final = new JRadioButton("RESULTADO FINAL");
		rb_resultado_final.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		rb_resultado_final.setBounds(413, 254, 176, 23);
		add(rb_resultado_final);
		
		// ButtonGroup para seleccionar solamente un rb a la vez
				ButtonGroup bg = new ButtonGroup();
				 bg.add(rb_sets);
				 bg.add(rb_puntuacion);
				 bg.add(rb_resultado_final);
				 bg.setSelected(rb_sets.getModel(), true);
				 

	}
	public static void mensaje(String error, String titulo) {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(null, error, titulo, 
			JOptionPane.PLAIN_MESSAGE, 
			JOptionPane.ERROR_MESSAGE)==0);
			
	}
}

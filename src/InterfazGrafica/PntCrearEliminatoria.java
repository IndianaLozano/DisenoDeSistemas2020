package InterfazGrafica;

import javax.swing.JPanel;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JCheckBox;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.Button;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class PntCrearEliminatoria extends JPanel {

	/**
	 * Create the panel.
	 */
	public PntCrearEliminatoria() {
		setPreferredSize(new Dimension(730, 460));
		setLayout(null);
		
		Label crearNuevaCompetenciaDeportiva = new Label();
		crearNuevaCompetenciaDeportiva.setText(" CREAR NUEVA COMPETENCIA DEPORTIVA");
		crearNuevaCompetenciaDeportiva.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crearNuevaCompetenciaDeportiva.setBounds(169, 22, 401, 24);
		add(crearNuevaCompetenciaDeportiva);
		
		Label crearNuevaCompetenciaDeportiva_1 = new Label();
		crearNuevaCompetenciaDeportiva_1.setText(" SISTEMA DE ELIMINATORIAS: FORMA DE PUNTUACI\u00D3N");
		crearNuevaCompetenciaDeportiva_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		crearNuevaCompetenciaDeportiva_1.setBounds(149, 52, 451, 24);
		add(crearNuevaCompetenciaDeportiva_1);
		
		Button btn_atras = new Button("Atr\u00E1s");
		btn_atras.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_atras.setBounds(65, 388, 70, 22);
		add(btn_atras);
		
		Button btn_sig = new Button("Siguiente");
		btn_sig.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_sig.setBounds(594, 388, 70, 22);
		add(btn_sig);
		
		JRadioButton rb_resultado_final = new JRadioButton("RESULTADO FINAL");
		rb_resultado_final.setFont(new Font("Calibri", Font.PLAIN, 14));
		rb_resultado_final.setBounds(189, 271, 140, 25);
		add(rb_resultado_final);
		
		JRadioButton rb_puntuacion = new JRadioButton("PUNTUACI\u00D3N");
		rb_puntuacion.setFont(new Font("Calibri", Font.PLAIN, 14));
		rb_puntuacion.setBounds(189, 211, 103, 25);
		add(rb_puntuacion);
		
		JComboBox cb_tantos_ganados_ausencia_rival = new JComboBox();
		cb_tantos_ganados_ausencia_rival.setModel(new DefaultComboBoxModel(new String[] {"Tantos ganados por ausencia del rival"}));
		cb_tantos_ganados_ausencia_rival.setBounds(297, 213, 245, 20);
		add(cb_tantos_ganados_ausencia_rival);
		
		JRadioButton rb_sets = new JRadioButton("SETS");
		rb_sets.setFont(new Font("Calibri", Font.PLAIN, 14));
		rb_sets.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		rb_sets.setBounds(189, 151, 51, 25);
		add(rb_sets);
		
		JComboBox cb_cantidad_de_sets = new JComboBox();
		cb_cantidad_de_sets.setModel(new DefaultComboBoxModel(new String[] {"Cantidad de sets"}));
		cb_cantidad_de_sets.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cb_cantidad_de_sets.setAlignmentX(0.0f);
		cb_cantidad_de_sets.setBounds(245, 153, 124, 20);
		add(cb_cantidad_de_sets);
		
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

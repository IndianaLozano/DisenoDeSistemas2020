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

import DTO.CompetenciaDTO;
import DTO.EliminatoriaDTO;
import Entidades.Puntuacion;
import Gestores.GestorCompetencia;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class PntCrearEliminatoria extends JPanel {

	public static EliminatoriaDTO eliminatoriaDTO= new EliminatoriaDTO();
	public static JComboBox cb_cantidad_sets = new JComboBox();
	public static JComboBox cb_tantos_ganados_ausencia_rival = new JComboBox();
	public static JRadioButton rb_puntuacion = new JRadioButton("PUNTUACI\u00D3N");
	public static JRadioButton rb_sets = new JRadioButton("SETS");
	public static JRadioButton rb_resultado_final = new JRadioButton("RESULTADO FINAL");
	public static CompetenciaDTO competenciaDTO= new CompetenciaDTO();
	
	
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
		btn_atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = VentanaAdmin.mensajeConsulta(null, "ATENCION!", "¿Desea cancelar la carga de datos?\nSe perderá toda la información cargada.");
				if(respuesta==JOptionPane.YES_OPTION) {
				VentanaAdmin.cambiarPantalla(VentanaAdmin.pntCrearCompetencia, VentanaAdmin.n_pntCrearCompetencia);				
				}
			}
		});
		btn_atras.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_atras.setBounds(65, 388, 70, 22);
		add(btn_atras);
		
		Button btn_sig = new Button("Siguiente");
		btn_sig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					llenarEliminatoriaDTO();
					GestorCompetencia.crearEliminatoria(competenciaDTO, eliminatoriaDTO);
				} catch (Exception e1) {
					e1.printStackTrace();
					String msj= e1.getMessage();
					VentanaAdmin.adminstrarExcepcion(msj);
				}
				
				VentanaAdmin.cambiarPantalla(VentanaAdmin.pntListarParticipantes, VentanaAdmin.n_pntListarParticipantes);
			}
		});
		btn_sig.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_sig.setBounds(594, 388, 70, 22);
		add(btn_sig);
		rb_resultado_final.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb_cantidad_sets.setEnabled(false);
				cb_tantos_ganados_ausencia_rival.setEnabled(false);
			}
		});
		
		rb_resultado_final.setFont(new Font("Calibri", Font.PLAIN, 14));
		rb_resultado_final.setBounds(189, 271, 140, 25);
		add(rb_resultado_final);
		rb_puntuacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb_cantidad_sets.setEnabled(false);
				cb_tantos_ganados_ausencia_rival.setEnabled(true);
			}
		});
		
		rb_puntuacion.setFont(new Font("Calibri", Font.PLAIN, 14));
		rb_puntuacion.setBounds(189, 211, 103, 25);
		add(rb_puntuacion);
		cb_tantos_ganados_ausencia_rival.setMaximumRowCount(9);
		cb_tantos_ganados_ausencia_rival.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		cb_tantos_ganados_ausencia_rival.setModel(new DefaultComboBoxModel(new String[] {"Tantos ganados por ausencia del rival"}));
		cb_tantos_ganados_ausencia_rival.setBounds(324, 213, 146, 20);
		cb_tantos_ganados_ausencia_rival.setEnabled(false);
		cb_tantos_ganados_ausencia_rival.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		add(cb_tantos_ganados_ausencia_rival);
		
		rb_sets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb_cantidad_sets.setEnabled(true);
				cb_tantos_ganados_ausencia_rival.setEnabled(false);
			}
		});
		
		rb_sets.setFont(new Font("Calibri", Font.PLAIN, 14));
		rb_sets.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		rb_sets.setBounds(189, 151, 51, 25);
		add(rb_sets);
		cb_cantidad_sets.setMaximumRowCount(9);
		cb_cantidad_sets.setAlignmentX(Component.LEFT_ALIGNMENT);
		cb_cantidad_sets.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		cb_cantidad_sets.setModel(new DefaultComboBoxModel(new String[] {"Cantidad de sets"}));
		cb_cantidad_sets.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cb_cantidad_sets.setBounds(324, 153, 146, 20);
		cb_cantidad_sets.setEnabled(true);
		cb_cantidad_sets.setModel(new DefaultComboBoxModel(new String[] {"1", "3", "5", "7", "9"}));
		add(cb_cantidad_sets);
		
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
	
	public static void llenarEliminatoriaDTO() {
		
		
		if(rb_sets.isSelected()) {
			eliminatoriaDTO.setPuntuacion(Puntuacion.Sets);
			eliminatoriaDTO.setCantidadSets(Integer.parseInt(cb_cantidad_sets.getSelectedItem().toString()));
			eliminatoriaDTO.setTantosGanadosAusRival(-1);
		}else if(rb_puntuacion.isSelected()) {
			eliminatoriaDTO.setPuntuacion(Puntuacion.Puntuacion);
			eliminatoriaDTO.setCantidadSets(-1);
			eliminatoriaDTO.setTantosGanadosAusRival(Integer.parseInt(cb_tantos_ganados_ausencia_rival.getSelectedItem().toString()));
		}else {
			eliminatoriaDTO.setPuntuacion(Puntuacion.ResultadoFinal);
			eliminatoriaDTO.setCantidadSets(-1);
			eliminatoriaDTO.setTantosGanadosAusRival(-1);
		} 
		
	}
}

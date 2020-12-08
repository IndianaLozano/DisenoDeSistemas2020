package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;

import DTO.CompDTO;
import Entidades.Competencia;
import Entidades.Estado;
import Entidades.MiExcepcion;
import Gestores.GestorCompetencia;
import Gestores.GestorFixture;

import javax.swing.JScrollBar;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PntVerCompetencia extends JPanel {
	public JTextField tf_nombre;
	public JTextField tf_modalidad;
	public JTextField tf_deporte;
	public JTextField tf_estado;
	
	public JButton btn_verEncuentros = new JButton("Ver Pr\u00F3ximos Encuentros");
	public JButton btn_generarFixture = new JButton("Generar Fixture");


	
	public int idCompetenciaActual;

	/**
	 * Create the panel.
	 */
	public PntVerCompetencia() {
		setBorder(null);
		setAlignmentY(0.0f);
		setAlignmentX(0.0f);
		setBounds(new Rectangle(1, 1, 724, 421));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VER COMPETENCIA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(310, 11, 158, 22);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(48, 87, 61, 14);
		add(lblNewLabel_1);
		
		tf_nombre = new JTextField();
		tf_nombre.setEditable(false);
		tf_nombre.setColumns(10);
		tf_nombre.setBounds(141, 86, 168, 20);
		add(tf_nombre);
		
		JLabel lblNewLabel_2 = new JLabel("Modalidad");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(48, 142, 75, 14);
		add(lblNewLabel_2);
		
		tf_modalidad = new JTextField();
		tf_modalidad.setEditable(false);
		tf_modalidad.setColumns(10);
		tf_modalidad.setBounds(141, 141, 168, 20);
		add(tf_modalidad);
		
		JLabel lblNewLabel_3 = new JLabel("Deporte");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(48, 192, 61, 22);
		add(lblNewLabel_3);
		
		tf_deporte = new JTextField();
		tf_deporte.setEditable(false);
		tf_deporte.setColumns(10);
		tf_deporte.setBounds(141, 195, 168, 20);
		add(tf_deporte);
		
		JButton btnNewButton = new JButton("Atr\u00E1s");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin.cambiarPantalla(VentanaAdmin.pntListarCompetencias,VentanaAdmin.n_pntListarCompetencias);
			}
		});
		btnNewButton.setBounds(34, 374, 75, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Estado");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(48, 248, 61, 14);
		add(lblNewLabel_4);
		
		tf_estado = new JTextField();
		tf_estado.setEditable(false);
		tf_estado.setColumns(10);
		tf_estado.setBounds(141, 247, 168, 20);
		add(tf_estado);
		
		JPanel panel = new JPanel();
		panel.setBounds(371, 84, 279, 296);
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_2 = new JButton("Modificar Competencia");
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Dar de Baja");
		btnNewButton_3.setBackground(SystemColor.inactiveCaption);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Consultar Fixture");
		btnNewButton_4.setBackground(SystemColor.inactiveCaption);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_7 = new JButton("Consultar Tabla de Posiciones");
		btnNewButton_7.setBackground(SystemColor.inactiveCaption);
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton_7);
		
		btn_generarFixture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (VentanaAdmin.mensajeConsulta(null, "SPORTsYSTEM", "¿Desea generar el Fixture para la Competencia actual?") == 0) {
 					Competencia c = new Competencia();
					try {
						c = GestorCompetencia.obtenerCompetencia(idCompetenciaActual).get(0);
						try {
							GestorFixture.generarFixture(c);
						
					} catch (MiExcepcion e1) {
						VentanaAdmin.administrarExcepcion(e1.getMessage());
					}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				} 

			}
		}); 

		btn_generarFixture.setBackground(SystemColor.inactiveCaption);
		btn_generarFixture.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btn_generarFixture);
		
		JButton btn_verParticipantes = new JButton("Consultar Lista de Participantes");
		btn_verParticipantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					VentanaAdmin.pntListarParticipantes.idCompetenciaActual= idCompetenciaActual ;
					PntListarParticipantes.cargarParticipantes(idCompetenciaActual);
					VentanaAdmin.cambiarPantalla(VentanaAdmin.pntListarParticipantes, VentanaAdmin.n_pntListarParticipantes);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_verParticipantes.setBackground(SystemColor.inactiveCaption);
		btn_verParticipantes.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btn_verParticipantes);
		
		btn_verEncuentros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin.pntVerEncuentro.idCompetenciaActual= idCompetenciaActual;
				try {
					
					VentanaAdmin.pntVerEncuentro.cargarEncuentrosProximos();
					VentanaAdmin.cambiarPantalla(VentanaAdmin.pntVerEncuentro, VentanaAdmin.n_pntVerEncuentros);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btn_verEncuentros.setBackground(SystemColor.inactiveCaption);
		panel.add(btn_verEncuentros);
		btn_verEncuentros.setFont(new Font("Tahoma", Font.BOLD, 12));

	}
	
	public void cargarDatos(CompDTO competDTO) {
	
		
		if (competDTO.getModalidad() != "SistemaDeLiga") {
			btn_generarFixture.setEnabled(false);
		}else {
			btn_generarFixture.setEnabled(true);
		}
		
		if (competDTO.getEstado() == "Creada" || competDTO.getEstado() == "Finalizada" || competDTO.getModalidad() !="SistemaDeLiga") {
			btn_verEncuentros.setEnabled(false);	
		}else {
			btn_verEncuentros.setEnabled(true);
		}
		
		
		
		tf_nombre.setText(competDTO.getNombre());
		tf_modalidad.setText(competDTO.getModalidad());
		tf_estado.setText(competDTO.getEstado());
		tf_deporte.setText(competDTO.getDeporte().getNombre());	
	}
}

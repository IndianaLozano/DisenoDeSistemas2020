package InterfazGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

import DTO.ParticipanteDTO;
import Entidades.Competencia;
import Entidades.MiExcepcion;
import Gestores.GestorCompetencia;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Button;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PntAltaParticipante extends JPanel {
	public JTextField tf_nombre;
	public JTextField tf_correo;
	
	public JPanel pantallaAnterior;
	public int idCompetenciaActual;
	
	public JLabel lbl_competencia = new JLabel("");


	/**
	 * Create the panel.
	 */
	public PntAltaParticipante() {
		setBounds(100, 100, 733, 434);
		setLayout(null);
		
		JTextPane txtpnAltaParticipante = new JTextPane();
		txtpnAltaParticipante.setText("ALTA DE PARTICIPANTES");
		txtpnAltaParticipante.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnAltaParticipante.setEditable(false);
		txtpnAltaParticipante.setBackground(SystemColor.menu);
		txtpnAltaParticipante.setBounds(273, 11, 219, 37);
		add(txtpnAltaParticipante);
		
		tf_nombre = new JTextField();
		tf_nombre.setToolTipText("");
		tf_nombre.setForeground(Color.BLACK);
		tf_nombre.setColumns(10);
		tf_nombre.setBounds(124, 138, 308, 20);
		add(tf_nombre);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setText("Nombre (*)");
		txtpnNombre.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtpnNombre.setEditable(false);
		txtpnNombre.setBackground(SystemColor.menu);
		txtpnNombre.setBounds(24, 138, 70, 30);
		add(txtpnNombre);
		
		Button button = new Button("Atr\u00E1s");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pantallaAnterior == VentanaAdmin.pntListarParticipantes) {
					VentanaAdmin.cambiarPantalla(VentanaAdmin.pntListarParticipantes, VentanaAdmin.n_pntListarParticipantes);
				}

			}
		});
		button.setBounds(52, 373, 70, 22);
		add(button);
		
		Button button_1 = new Button("Aceptar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_nombre.getText().length()>0 && tf_correo.getText().length()>0) {
					ParticipanteDTO pDTO = new ParticipanteDTO();
					pDTO.setNombre(tf_nombre.getText());
					pDTO.setCorreo(tf_correo.getText());
					try {
						Competencia c = GestorCompetencia.obtenerCompetencia(idCompetenciaActual).get(0);
						boolean val = GestorCompetencia.validarDatosParticipante(pDTO, c);
						
						if (val==true) {
							GestorCompetencia.altaParticipante(pDTO, c);
						}
					
					} catch (MiExcepcion e1) {
						VentanaAdmin.administrarExcepcion(e1.getMessage());
						try {
							PntListarParticipantes.actualizarTabla(idCompetenciaActual);
						} catch (Exception e2) {
						}

					} catch (Exception e1) {
					}
					finally {
						tf_nombre.setText(null);
						tf_correo.setText(null);
					}
					
				}else {
					VentanaAdmin.mensajeError("Faltan campos obligatorios por completar", "Error");
				}
			}
		});
		button_1.setBounds(595, 373, 70, 22);
		add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 69, 705, 216);
		add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnCorreoElectronico = new JTextPane();
		txtpnCorreoElectronico.setBounds(10, 139, 92, 37);
		panel.add(txtpnCorreoElectronico);
		txtpnCorreoElectronico.setText("Correo electr\u00F3nico (*)");
		txtpnCorreoElectronico.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtpnCorreoElectronico.setEditable(false);
		txtpnCorreoElectronico.setBackground(SystemColor.menu);
		
		tf_correo = new JTextField();
		tf_correo.setBounds(110, 156, 308, 20);
		panel.add(tf_correo);
		tf_correo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Competencia:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 92, 20);
		panel.add(lblNewLabel);
		
		lbl_competencia.setForeground(new Color(0, 0, 128));
		lbl_competencia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_competencia.setBounds(112, 11, 306, 20);
		panel.add(lbl_competencia);
	}
	
	/*public static void opcConsulta(String[] arg){
	String[] options = {"SI", "NO"};
	int seleccion = JOptionPane.showOptionDialog(null, "¿Desea cancelar la carga de datos?\nSe perderá toda la información cargada.", "SPORTsYSTEM"
			+ "", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
	System.out.println(seleccion);
	}*/
	
	public  void formatoPantalla(int idCompetencia) throws Exception {
		Competencia c = GestorCompetencia.obtenerCompetencia(idCompetencia).get(0);
		lbl_competencia.setText(c.nombre);
	}
	
		
	
	
	
	
}

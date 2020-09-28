package InterfazGrafica;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {


	ImageIcon imagen;
	String url;
	
	public PanelFondo() {
		setVisible(true);

	}
	
	public PanelFondo (String url) {
		this.url = url;
		
	}
	
	public void paint (Graphics g) {
		Dimension tamanio= this.getSize();
		imagen = new ImageIcon(getClass().getResource(url));
		g.drawImage(imagen.getImage(),0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paint(g);
	}

}

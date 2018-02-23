package vista;

import javax.swing.JPanel;

import controlador.MyActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class Botonera extends JPanel {

	public JButton botones[][];
	int anchoPanel = 150, altoPanel = 150;
	int ladoBoton = 50;

	/**
	 * Create the panel.
	 */
	public Botonera(int x, int y) {
		setForeground(Color.BLACK);
		setBackground(Color.DARK_GRAY);
		this.setBounds(x, y, this.anchoPanel, this.altoPanel);
		setLayout(null);
		iniciarBotonera();
	}

	private void iniciarBotonera() {
		this.botones = new JButton[3][3];
		int x = 0, y = 0;
		for (int i = 0; i < this.botones.length; i++) {
			for (int j = 0; j < this.botones[i].length; j++) {
				this.botones[i][j] = new JButton();
				this.botones[i][j].setName(String.valueOf(i) + String.valueOf(j));
				this.botones[i][j].setBorder(new LineBorder(Color.BLACK, 2));
				this.botones[i][j].setContentAreaFilled(false);
				this.botones[i][j].setBounds(x, y, this.ladoBoton, this.ladoBoton);
				this.botones[i][j].setOpaque(true);
				this.botones[i][j].setForeground(Color.WHITE);
				this.botones[i][j].setFont(new Font("Tahoma", 1, 24));
				this.add(this.botones[i][j]);
				x += this.ladoBoton;
			}
			x = 0;
			y += this.ladoBoton;
		}
	}
}

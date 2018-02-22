package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Dimension;

public class TresNRayaUI extends JFrame {

	private JPanel contentPane;
	protected Botonera botonera;
	private JTextField txtMensaje;
	private JTextField txtAnomalia;
	/**
	 * Create the frame.
	 */
	public TresNRayaUI() {
		setTitle("Tres en raya");
		setMinimumSize(new Dimension(450, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{424, 411, 0};
		gbl_contentPane.rowHeights = new int[]{0, 251, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		txtMensaje = new JTextField();
		txtMensaje.setEditable(false);
		txtMensaje.setEnabled(false);
		GridBagConstraints gbc_txtMensaje = new GridBagConstraints();
		gbc_txtMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_txtMensaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMensaje.gridx = 0;
		gbc_txtMensaje.gridy = 0;
		contentPane.add(txtMensaje, gbc_txtMensaje);
		txtMensaje.setColumns(10);
		
		txtAnomalia = new JTextField();
		txtAnomalia.setEnabled(false);
		txtAnomalia.setEditable(false);
		GridBagConstraints gbc_txtAnomalia = new GridBagConstraints();
		gbc_txtAnomalia.insets = new Insets(0, 0, 5, 0);
		gbc_txtAnomalia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAnomalia.gridx = 1;
		gbc_txtAnomalia.gridy = 0;
		contentPane.add(txtAnomalia, gbc_txtAnomalia);
		txtAnomalia.setColumns(10);
		botonera=new Botonera(50, 50);
		GridBagConstraints gbc_botonera = new GridBagConstraints();
		gbc_botonera.gridwidth = 2;
		gbc_botonera.fill = GridBagConstraints.BOTH;
		gbc_botonera.gridx = 0;
		gbc_botonera.gridy = 1;
		contentPane.add(botonera, gbc_botonera);
		botonera.setLayout(new GridLayout(3, 3, 0, 0));
	}
}

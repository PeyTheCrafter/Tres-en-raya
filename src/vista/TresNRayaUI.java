package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class TresNRayaUI extends JFrame {
	private JPanel contentPane;
	protected Botonera botonera;
	protected JTextField txtMensaje;
	protected JTextField txtAnomalia;
	protected JLabel lblTurno;
	protected JLabel lblJugada;

	/**
	 * Create the frame.
	 */
	public TresNRayaUI() {
		// Estilo visual de windows.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setTitle("Tres en raya");
		setMinimumSize(new Dimension(450, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 302);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 25, 251, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		txtMensaje = new JTextField();
		txtMensaje.setBorder(null);
		txtMensaje.setForeground(Color.WHITE);
		txtMensaje.setBackground(Color.DARK_GRAY);
		txtMensaje.setEditable(false);
		GridBagConstraints gbc_txtMensaje = new GridBagConstraints();
		gbc_txtMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_txtMensaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMensaje.gridx = 0;
		gbc_txtMensaje.gridy = 0;
		contentPane.add(txtMensaje, gbc_txtMensaje);
		txtMensaje.setColumns(10);

		txtAnomalia = new JTextField();
		txtAnomalia.setBorder(null);
		txtAnomalia.setBackground(Color.DARK_GRAY);
		txtAnomalia.setForeground(Color.WHITE);
		txtAnomalia.setEditable(false);
		GridBagConstraints gbc_txtAnomalia = new GridBagConstraints();
		gbc_txtAnomalia.insets = new Insets(0, 0, 5, 0);
		gbc_txtAnomalia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAnomalia.gridx = 1;
		gbc_txtAnomalia.gridy = 0;
		contentPane.add(txtAnomalia, gbc_txtAnomalia);
		txtAnomalia.setColumns(10);

		lblTurno = new JLabel("");
		lblTurno.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurno.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTurno = new GridBagConstraints();
		gbc_lblTurno.fill = GridBagConstraints.BOTH;
		gbc_lblTurno.insets = new Insets(0, 0, 5, 5);
		gbc_lblTurno.gridx = 0;
		gbc_lblTurno.gridy = 1;
		contentPane.add(lblTurno, gbc_lblTurno);

		lblJugada = new JLabel("");
		lblJugada.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblJugada = new GridBagConstraints();
		gbc_lblJugada.insets = new Insets(0, 0, 5, 0);
		gbc_lblJugada.gridx = 1;
		gbc_lblJugada.gridy = 1;
		contentPane.add(lblJugada, gbc_lblJugada);
		
		botonera = new Botonera(50, 50);
		botonera.setForeground(Color.WHITE);
		botonera.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_botonera = new GridBagConstraints();
		gbc_botonera.gridwidth = 2;
		gbc_botonera.fill = GridBagConstraints.BOTH;
		gbc_botonera.gridx = 0;
		gbc_botonera.gridy = 2;
		contentPane.add(botonera, gbc_botonera);
		botonera.setLayout(new GridLayout(3, 3, 0, 0));
	}
}

package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.xml.bind.Marshaller.Listener;

import vista.Botonera;

public class MyActionListener implements ActionListener {

	TresNRaya control;
	ParaTresNRayaUI paraUI;

	public MyActionListener(TresNRaya control, ParaTresNRayaUI paraUI) {
		super();
		this.control = control;
		this.paraUI = paraUI;
	}

	/*
	 * PROBLEMAS: 1. No se borra la ficha una vez movida.
	 */

	/*
	 * Posibles actualizaciones: 1. Cambiar color de borde de la ficha seleccionada.
	 * 2. Cambiar color de borde de la ficha del turno actual. 3. cambiar color de
	 * borde de la ficha del turno actual que no esté bloqueada.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton) e.getSource();
		String coordenadas = boton.getName();
		paraUI.terMain(coordenadas);
	}
}

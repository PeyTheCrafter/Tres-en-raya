package controlador;

import java.awt.Color;

import javax.swing.border.LineBorder;

import vista.TresNRayaUI;
import javax.swing.SwingConstants;

public class ParaTresNRayaUI extends TresNRayaUI {
	TresNRaya control = new TresNRaya();
	MyActionListener listener = new MyActionListener(control, this);

	public ParaTresNRayaUI() {
		super();
		txtAnomalia.setBorder(null);
		txtMensaje.setBorder(null);
		lblTurno.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugada.setForeground(Color.WHITE);
		lblTurno.setForeground(Color.WHITE);
		actualizarVentana();
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones[i].length; j++) {
				this.botonera.botones[i][j].addActionListener(listener);
			}
		}
	}

	public void terMain(String coordenadas) {
		int x = interpretarCoordenada(coordenadas)[0];
		int y = interpretarCoordenada(coordenadas)[1];
		// mostrarTablero();
		if (!this.control.comprobarTresEnRaya()) {
			this.control.destinox = x;
			this.control.destinoy = y;
			if (!this.control.realizarJugada()) {
				txtAnomalia.setText(this.control.indicarAnomalia());
			}
			actualizarVentana();
		}
	}

	/**
	 * Muestra el tablero por consola.
	 */
	private void mostrarTablero() {
		int[][] tablero = this.control.tablero;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Separa el String de coordenadas.
	 * 
	 * @param coordenada
	 *            String con las coordenadas.
	 * @return Array con las coordenadas x e y.
	 */
	public int[] interpretarCoordenada(String coordenada) {
		int[] coord = { 0, 0 };
		coord[0] = Character.getNumericValue((coordenada.charAt(0)));
		coord[1] = Character.getNumericValue((coordenada.charAt(1)));
		return coord;
	}

	/**
	 * Actualiza los textos de los botones.
	 */
	public void actualizarVentana() {
		resaltarCasillas();
		actualizarBotones();
		actualizarInformacion();
	}

	/**
	 * Controla el resaltado de las casillas
	 */
	private void resaltarCasillas() {
		limpiarMarcas();
		if (!this.control.comprobarTresEnRaya()) {
			marcarTurnoActual();
		} else {
			marcarGanador(cambiarTurno());
		}
	}

	/**
	 * Cambia el turno al opuesto, porque cada vez que se hace una jugada se cambia.
	 * 
	 * @return el turno cambiado
	 */
	private int cambiarTurno() {
		if (this.control.verTurno() == 2) {
			return 1;
		}
		return 2;
	}

	/**
	 * Marca la formación ganadora.
	 */
	private void marcarGanador(int turno) {
		for (int i = 0; i < this.control.tablero.length; i++) {
			for (int j = 0; j < this.control.tablero.length; j++) {
				if (this.control.tablero[i][j] == turno) {
					this.botonera.botones[i][j].setBorder(new LineBorder(new Color(64, 255, 64), 6));
					this.botonera.botones[i][j].setBackground(new Color(32, 128, 32));
				}
			}
		}
	}

	/**
	 * Limpia las marcas de las casillas.
	 */
	private void limpiarMarcas() {
		for (int i = 0; i < this.control.tablero.length; i++) {
			for (int j = 0; j < this.control.tablero.length; j++) {
				this.botonera.botones[i][j].setBorder(new LineBorder(new Color(0, 0, 0), 1));
				this.botonera.botones[i][j].setBackground(new Color(64, 64, 64));
			}
		}
	}

	/**
	 * Marca las casillas del turno actual.
	 */
	private void marcarTurnoActual() {
		for (int i = 0; i < this.control.tablero.length; i++) {
			for (int j = 0; j < this.control.tablero.length; j++) {
				if (this.control.tablero[i][j] == this.control.verTurno()) {
					this.botonera.botones[i][j].setBorder(new LineBorder(new Color(0, 128, 255), 3));
					this.botonera.botones[i][j].setBackground(new Color(0, 64, 128));
				}
			}
		}
	}

	/**
	 * Actualiza la información superior de la ventana.
	 */
	private void actualizarInformacion() {
		lblTurno.setText("Turno: " + String.valueOf(this.control.verTurno()));
		lblJugada.setText("Jugada: " + this.control.numerojugada);
		txtMensaje.setText(this.control.muestraLetrero());
		txtAnomalia.setText(this.control.indicarAnomalia());
	}

	/**
	 * Actualiza el contenido de los botones (casillas).
	 */
	private void actualizarBotones() {
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones.length; j++) {
				this.botonera.botones[i][j]
						.setText(String.valueOf(this.control.retornaSimbolo(this.control.tablero[i][j])));
			}
		}
	}
}

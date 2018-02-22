package controlador;

import javax.swing.JButton;

import vista.TresNRayaUI;

public class ParaTresNRayaUI extends TresNRayaUI {
	TresNRaya control = new TresNRaya();
	MyActionListener listener = new MyActionListener(control, this);

	public ParaTresNRayaUI() {
		super();
		actualizarBotones();
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones[i].length; j++) {
				this.botonera.botones[i][j].addActionListener(listener);
			}
		}
	}

	public void terMain(String coordenadas) {
		int x = interpretarCoordenada(coordenadas)[0];
		int y = interpretarCoordenada(coordenadas)[1];
		JButton boton = this.botonera.botones[x][y];
		System.out.println("Coordenadas: " + x + " " + y);
		// Establecer las coordenadas.
		if (this.control.numerojugada < 7) {
			if (this.control.tablero[x][y] == 0) {
				this.control.destinox = x;
				this.control.destinoy = y;
			} else {
				System.out.println(this.control.indicarAnomalia());
			}
		} else {
			// Mover fichas.
		}

		System.out.println(this.control.indicarAnomalia());
		System.out.println(this.control.muestraLetrero());

		// Proceso normal de juego.
		this.control.realizarJugada();
		actualizarBotones();
		mostrarTablero();
		System.out.println("Turno: " + this.control.verTurno());
		System.out.println("Número jugada: " + this.control.numerojugada);

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
	public void actualizarBotones() {
		limpiarBotones();
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones.length; j++) {
				 this.botonera.botones[i][j]
				 .setText(String.valueOf(this.control.retornaSimbolo(this.control.tablero[i][j])));
				//this.botonera.botones[i][j].setText(String.valueOf(this.control.tablero[i][j]));
			}
		}
	}

	/**
	 * Borra los textos de los botones.
	 */
	private void limpiarBotones() {
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones.length; j++) {
				this.botonera.botones[i][j].setText("");
			}
		}
	}
}

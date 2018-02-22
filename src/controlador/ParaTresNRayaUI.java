package controlador;

import vista.TresNRayaUI;

public class ParaTresNRayaUI extends TresNRayaUI {
	TresNRaya control = new TresNRaya();
	MyActionListener listener = new MyActionListener(control, this);

	public ParaTresNRayaUI() {
		super();
		actualizarVentana();
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones[i].length; j++) {
				this.botonera.botones[i][j].addActionListener(listener);
			}
		}
	}

	public void terMain(String coordenadas, String simbolo) {
		for (int i = 0; i < 20; i++) {
			System.out.println();
		}
		int x = interpretarCoordenada(coordenadas)[0];
		int y = interpretarCoordenada(coordenadas)[1];
		// Establecer las coordenadas.
		if (this.control.numerojugada <= 6) {
			if (this.control.tablero[x][y] == 0) {
				this.control.destinox = x;
				this.control.destinoy = y;
			}
		} else {

		}

		// Proceso normal de juego.
		this.control.realizarJugada();

		actualizarVentana();
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
	public void actualizarVentana() {
		actualizarBotones();
		actualizarInformacion();
	}
	
	private void actualizarInformacion() {
		lblTurno.setText("Turno: " + String.valueOf(this.control.verTurno()));
		lblJugada.setText("Jugada: " + this.control.numerojugada);
	}

	private void actualizarBotones() {
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones.length; j++) {
				this.botonera.botones[i][j]
						.setText(String.valueOf(this.control.retornaSimbolo(this.control.tablero[i][j])));
			}
		}
	}
}

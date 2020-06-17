package juego;

import java.awt.Rectangle;

import javax.swing.JPanel;

public class Topo extends Personaje{
	private String Sentido;

	Topo(JPanel MiJ, int x, int y) {
		super(MiJ);
		this.x=x;
		this.y=y;
		this.Sentido="ESTE";
	}
		public void movimientoTopo() {
			if(this.y<0) {
				this.Sentido="ESTE";
				this.y=this.y+10;
				this.setDireccion("src/juego/imagenes/topo.png");
			
			}
			else if (this.y>this.getPanel().getHeight()-150) {
				this.Sentido="OESTE";
				this.y=this.y-10;
				this.setDireccion("src/juego/imagenes/topo.png");
			}
			
			else if(this.Sentido.contentEquals("ESTE")) {
				this.y=this.y+10;
				this.setDireccion("src/juego/imagenes/topo.png");
			}
			else if(this.Sentido.contentEquals("OESTE")) {
				this.y=this.y-10;
				this.setDireccion("src/juego/imagenes/topo.png");
		}
	}

}

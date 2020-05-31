package juego;

import javax.swing.JPanel;
import java.awt.Rectangle;

public class Link extends Personaje{

	int salud;
	private int escudo;
	private int arma;
	
	
	Link(JPanel MiJ, int s, int e, int a) {
		super(MiJ); 
		this.salud=s;
		this.escudo=e;
		this.arma=a;
		
	}
	
	public int getSalud() {
		return this.salud;
	}
	
	public void restarSalud() {
		if(salud > 0 )
		this.salud-=20;
	}
	
	public int getEscudo() {
		return this.escudo;
	}
	
	public int getArma() {
		return this.arma;
	}
	
	public void setSalud(int s) {
		this.salud=s;
	}
	
	public void setEscudo(int e) {
		this.escudo=e;
	}
	
	public void setArma(int a) {
		this.arma=a;
	}
	

}

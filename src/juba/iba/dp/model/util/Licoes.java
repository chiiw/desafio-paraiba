package juba.iba.dp.model.util;

import java.io.Serializable;

public class Licoes implements Serializable {
	private static final long serialVersionUID = 1657039956949979285L;

	private boolean um;
	private boolean dois;
	private boolean tres;
	private boolean quatro;
	private boolean cinco;
	private boolean seis;
	private boolean sete;
	
	public boolean isUm() {
		return um;
	}
	public void setUm(boolean um) {
		this.um = um;
	}
	public boolean isDois() {
		return dois;
	}
	public void setDois(boolean dois) {
		this.dois = dois;
	}
	public boolean isTres() {
		return tres;
	}
	public void setTres(boolean tres) {
		this.tres = tres;
	}
	public boolean isQuatro() {
		return quatro;
	}
	public void setQuatro(boolean quatro) {
		this.quatro = quatro;
	}
	public boolean isCinco() {
		return cinco;
	}
	public void setCinco(boolean cinco) {
		this.cinco = cinco;
	}
	public boolean isSeis() {
		return seis;
	}
	public void setSeis(boolean seis) {
		this.seis = seis;
	}
	public boolean isSete() {
		return sete;
	}
	public void setSete(boolean sete) {
		this.sete = sete;
	}
}

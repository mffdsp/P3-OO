package com.schedule;

public class Mensal extends Agenda{
	
	private int dia = 0;
	
	public String toString() {
		return "Mensal - " + dia;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}
}

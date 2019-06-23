package com.employee;

import com.adm.CalendarMT;
import com.adm.SystemMT;

public class Comissionado extends Funcionario implements SystemMT {
	
	private double valordevendas;
	private double realSalary = 0;
	private String pday = "Sexta-Feira"; 
	private int frequenciaD = 6;
	private int frequencia = 2;
	private int pvenda = 15;
	
	@Override
	public String toString() {
		return name + " - " + code +  " - " + this.realSalary + "RS" + " / Pago via: " + payMode;
	}
	
	public boolean pagarFuncionario() {
		
		setPago(frequenciaD >= frequencia*7 && CalendarMT.weekday.equals(pday));
		if(isPago()) {
			
			 frequenciaD = 6;
		}
		return isPago();
	}
	
	
	public void setPday(String pday) {
		this.pday = pday;
	}
	public String getPday() {
		return pday;
	}
	public double getValordevendas() {
		return valordevendas;
	}

	public void setValordevendas(double valordevendas) {
		this.valordevendas = valordevendas;
	}

	public double getRealSalary() {
		return realSalary;
	}

	public void setRealSalary(double realSalary) {
		this.realSalary += realSalary;
	}

	public int getFrequenciaD() {
		return frequenciaD;
	}

	public void setFrequenciaD(int frequenciaD) {
		this.frequenciaD += frequenciaD;
	}
	
	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	public int getPVenda() {
		return pvenda;
	}

	public void setPVenda(int pvenda) {
		this.pvenda = pvenda;
	}
}

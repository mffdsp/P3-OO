package com.payroll;


import java.util.Calendar;
import java.util.Date;

public class Horista extends Funcionario implements SystemMT{
	
     // Getting the day of the week
	protected double salarioBase = 0;
	protected int tipo = 1;
	protected int diasTB = 0;
	private String pday = "Sexta-Feira"; 
	private int frequenciaD = 6;
	private int frequencia = 1;
	
	
	public int getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	public boolean pagarFuncionario() {
		
		setPago(frequenciaD >= frequencia*7 && CalendarMT.weekday.equals(pday));
		if(isPago()) {
			 frequenciaD = 6;
		}
		return isPago();
	
	}
	
	public void addSalary(int horas){
		if(horas <= 8) {
			super.salary += horas * salarioBase;
		}else {
			super.salary += 8 * salarioBase;
			horas -= 8;
			super.salary += horas * (salarioBase*1.5);
		}
		
	}
	
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public double getSalarioBase() {
		return salarioBase;
	}

	public String getPday() {
		return pday;
	}

	public void setPday(String pday) {
		this.pday = pday;
	}


	public int getFrequenciaD() {
		return frequenciaD;
	}

	public void setFrequenciaD(int frequenciaD) {
		this.frequenciaD += frequenciaD;
	}
}
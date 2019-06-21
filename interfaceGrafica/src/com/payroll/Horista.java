package com.payroll;


import java.util.Calendar;
import java.util.Date;

public class Horista extends Funcionario implements SystemMT{
	
	Calendar c = Calendar.getInstance();
     // Getting the day of the week
	protected double salarioBase = 0;
	protected int tipo = 1;
	protected int diasTB = 0;
	private String pday = "Sexta-Feira"; 
	protected boolean pago = false;
	

	public boolean pagarFuncionario() {
		
		if(tipo == 1) {
			if(diasTB >= 7 && CalendarMT.weekday.equals(pday)) {
				pago = true; 
				return pago;
			}
		}else {
			if(diasTB > 12 && CalendarMT.weekday.equals(pday)) {
				pago = true;
				return pago;
			}
			
		}
		return pago;
	
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
}
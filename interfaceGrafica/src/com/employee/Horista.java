package com.employee;

import com.adm.CalendarMT;
import com.adm.SystemMT;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class Horista extends Funcionario implements SystemMT{
	
	protected double salarioBase = 0;
	private double psalary = 0;
	private int frequenciaD = 6;
	
	@Override
	public String toString() {
		return name + " / " + code +  " / " + salary + "RS";
	}
	
	public boolean pagarFuncionario() {

		boolean Uday = false;
		
		if(super.agenda instanceof Mensal)
		{
			Uday = ( CalendarMT.Adia >= (((Mensal)super.agenda).getDia() - 2) && CalendarMT.weekday.equals("Sexta-Feira") ) ||
					(CalendarMT.Adia == ((Mensal)super.agenda).getDia() && !CalendarMT.weekday.equals("Domingo")&& !CalendarMT.weekday.equals("Sabado"));
			
			setPago(Uday && frequenciaD >= 30);
			if(isPago()) {
			frequenciaD = 26;
			}
			
		}else if(super.agenda instanceof Semanal) {
			
			setPago(frequenciaD >= ((Semanal)super.agenda).getFrequencia()*7 && CalendarMT.weekday.equals(((Semanal)super.agenda).getDia()));
			if(isPago()) {
				 frequenciaD = 6;
			}
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

	public int getFrequenciaD() {
		return frequenciaD;
	}

	public void setFrequenciaD(int frequenciaD) {
		this.frequenciaD += frequenciaD;
	}
	
	public double getPsalary() {
		return psalary;
	}

	public void setPsalary(double psalary) {
		this.psalary = psalary;
	}

}
package com.employee;

import com.adm.CalendarMT;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class Horista extends Funcionario implements Cloneable{
	
	
	@Override
	public Horista clone() throws CloneNotSupportedException {
	        return (Horista) super.clone();
	}
	
	protected double salarioBase = 0;
	private double psalary = 0;
	
	public boolean pagarFuncionario() {

		boolean Uday = false;
		
		//Metodo obrigatório devido a interface, pode ser alterado em um tipo sem modificar os demais.
		if(super.agenda instanceof Mensal)
		{
			Uday = ( CalendarMT.Adia >= (((Mensal)super.agenda).getDia() - 2) && CalendarMT.weekday.equals("Sexta-Feira") ) ||
					(CalendarMT.Adia == ((Mensal)super.agenda).getDia() && !CalendarMT.weekday.equals("Domingo")&& !CalendarMT.weekday.equals("Sabado"));
			
			setPago(Uday && frequenciaD >= 30);
			
		}else if(super.agenda instanceof Semanal) {
			 
			setPago(frequenciaD >= ((Semanal)super.agenda).getFrequencia()*7 && CalendarMT.weekday.equals(((Semanal)super.agenda).getDia()));
		}
		if(isPago()) {
			super.frequenciaD = 5;
			super.setURpago(true);
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
	
	public double getPsalary() {
		return psalary;
	}

	public void setPsalary(double psalary) {
		this.psalary = psalary;
	}

}
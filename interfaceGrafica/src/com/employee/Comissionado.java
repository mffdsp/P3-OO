package com.employee;

import com.adm.CalendarMT;
import com.adm.SystemMT;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class Comissionado extends Funcionario implements SystemMT {
	
	private double valordevendas;
	private double realSalary = 0;
	private double psalary = 0;
	private int frequenciaD = 6;
	
	private int pvenda = 15;
	
	@Override
	public String toString() {
		return name + " - " + code +  " - " + realSalary + "RS" + " / Pago via: " + payMode;
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
	
	public int getPVenda() {
		return pvenda;
	}

	public void setPVenda(int pvenda) {
		this.pvenda = pvenda;
	}

	public double getPsalary() {
		return psalary;
	}

	public void setPsalary(double psalary) {
		this.psalary = psalary;
	}
}

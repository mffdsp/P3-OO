package com.employee;

import com.adm.CalendarMT;
import com.adm.SystemMT;
import com.schedule.Agenda;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class Assalariado extends Funcionario implements SystemMT{

	private String pday = "Segunda-Feira"; //add
	private int frequenciaD = 30; 

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
	public int getFrequenciaD() {
		return frequenciaD;
	}

	public void setFrequenciaD(int frequenciaD) {
		this.frequenciaD += frequenciaD;
	}
	public String getPday() {
		return pday;
	}
	public void setPday(String pday) {
		this.pday = pday;
	}


}

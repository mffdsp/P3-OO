package com.employee;

import com.adm.CalendarMT;
import com.adm.SystemMT;

public class Assalariado extends Funcionario implements SystemMT{

	
	private int payday = 30;
	private int frequenciaD = 30; 
	
	
	public boolean pagarFuncionario() {
		
		boolean Uday = false;
		Uday = ( CalendarMT.Adia >= (payday - 2) && CalendarMT.weekday.equals("Sexta-Feira") ) ||
				(CalendarMT.Adia == payday && !CalendarMT.weekday.equals("Domingo")&& !CalendarMT.weekday.equals("Sabado"));
		
		setPago(Uday && frequenciaD >= 30);
			
		if(isPago()) {
			frequenciaD = 26;
		}
		return isPago();
	
	}
	public int getPayday() {
		return payday;
	}

	public void setPayday(int payday) {
		this.payday = payday;
	}
	public int getFrequenciaD() {
		return frequenciaD;
	}

	public void setFrequenciaD(int frequenciaD) {
		this.frequenciaD += frequenciaD;
	}


}

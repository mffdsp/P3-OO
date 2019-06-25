package com.adm;

import javax.swing.JOptionPane;

import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class Command {
	
	public static int SSindex = 0;
	public static int UNDOAC = 0;
	public static boolean URpago[] = new boolean[500];
	public static int AgendaIndex = 0;
	public static SaveState[][] SS = new SaveState[500][500];
	
	public static void saveS(Funcionario[] func) {
		
    	SSindex += 1;
    	System.out.println("SALVOU");
    	for(int i = 0; i < 500; i++) {
			if(func[i] != null) 
			{
				SS[i][SSindex] = new SaveState();
				SS[i][SSindex].setAgendaToString(func[i].getAgendaToString());
				SS[i][SSindex].setName(func[i].getName());
				SS[i][SSindex].setSalary(func[i].getSalary());
				SS[i][SSindex].setAdress(func[i].getAdress());
				SS[i][SSindex].setPayMode(func[i].getPayMode());
				SS[i][SSindex].setType(func[i].getType()); 
				SS[i][SSindex].setSindicaty(func[i].isSindicaty());
				SS[i][SSindex].setCode(func[i].getCode());
				SS[i][SSindex].setScode(func[i].getSindicatycode());
				SS[i][SSindex].setSaved(func[i].isSaved());
				SS[i][SSindex].setCheckIN(func[i].isCheckIN());
				SS[i][SSindex].setCheckOUT(func[i].isCheckOUT());
				SS[i][SSindex].setAindex(Command.AgendaIndex);
				SS[i][SSindex].setCustom(func[i].isCustom());
				SS[i][SSindex].setPayboo(CalendarMT.payboo[CalendarMT.DAYSGONE]);
				SS[i][SSindex].setAgenda(func[i].getAgenda());
				SS[i][SSindex].setAgendaID(func[i].getAgendaID());
				SS[i][SSindex].setFrequenciaD(func[i].getFrequenciaD());
				SS[i][SSindex].setPassouD(func[i].getPassouD());
				SS[i][SSindex].setSalarybup(func[i].getSalarybup());
				if(func[i] instanceof Horista) {
					SS[i][SSindex].setSalarioBase(((Horista) func[i]).getSalarioBase());
					SS[i][SSindex].setPsalary(((Horista) func[i]).getPsalary());
				}
				if(func[i] instanceof Comissionado) {
					SS[i][SSindex].setBonussalary(((Comissionado) func[i]).getBonussalary());
					SS[i][SSindex].setPVenda(((Comissionado) func[i]).getPVenda());
					SS[i][SSindex].setPsalary(((Comissionado) func[i]).getPsalary());
				}
				if(func[i] instanceof Assalariado) {
					SS[i][SSindex].setPsalary(((Assalariado) func[i]).getPsalary());
				}
				
				
			}
			
		}
    	
	}
	public static void undo(Funcionario[] teste){
		try {
			if(SSindex == 1) {
				System.out.println("EMPTY STACK");
				return;
			}
			System.out.println("UNDONE");
			UNDOAC += 1;
			SSindex -= 1;
			for(int i = 0; i < 500; i++) {
				try {
				if(SS[i][SSindex].getType().equals("Comissionado")) {
					teste[i] = new Comissionado();
				}if(SS[i][SSindex].getType().equals("Horista")) {
					teste[i] = new Horista();
				}if(SS[i][SSindex].getType().equals("Assalariado")) {
					teste[i] = new Assalariado();
				}
				CalendarMT.payboo[CalendarMT.DAYSGONE] = SS[i][SSindex].isPayboo();
				teste[i].setAgendaToString(SS[i][SSindex].getAgendaToString());
				teste[i].setName(SS[i][SSindex].getName());
				teste[i].setSalary(SS[i][SSindex].getSalary());
				teste[i].setAdress(SS[i][SSindex].getAdress());
				teste[i].setPayMode(SS[i][SSindex].getPayMode());
				teste[i].setType(SS[i][SSindex].getType());
				teste[i].setSindicaty(SS[i][SSindex].isSindicaty());
				teste[i].setCode(SS[i][SSindex].getCode());
				teste[i].setSindicatycode(SS[i][SSindex].getScode());
				teste[i].setSaved(SS[i][SSindex].isSaved());
				teste[i].setCheckIN(SS[i][SSindex].isCheckIN());
				teste[i].setCheckOUT(SS[i][SSindex].isCheckOUT());
				teste[i].setCustom(SS[i][SSindex].isCustom());
				teste[i].setFrequenciaD(SS[i][SSindex].getFrequenciaD());
				teste[i].setSalarybup(SS[i][SSindex].getSalarybup());
				if(teste[i] instanceof Horista) {
					((Horista) teste[i]).setSalarioBase(SS[i][SSindex].getSalarioBase());
					((Horista) teste[i]).setPsalary(SS[i][SSindex].getPsalary());
					
				}
				if(teste[i] instanceof Comissionado) {
					((Comissionado) teste[i]).setBonussalary(SS[i][SSindex].getBonussalary());
					((Comissionado) teste[i]).setPVenda(SS[i][SSindex].getPVenda());
					((Comissionado) teste[i]).setPsalary(SS[i][SSindex].getPsalary());
				}
				if(teste[i] instanceof Assalariado) {
					((Assalariado) teste[i]).setPsalary(SS[i][SSindex].getPsalary());
				}
				teste[i].setAgenda(SS[i][SSindex].getAgenda());
				teste[i].setAgendaID(SS[i][SSindex].getAgendaID());
				}
				catch(Exception ex) {
					System.err.print(ex);
				}
			}
		} catch(Exception ex2) {
			System.out.println(ex2.getMessage());
			JOptionPane.showMessageDialog(null ,
					"Não há ações para desfazer", "Empty Stack!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public static void redo(Funcionario[] teste){
		try {
			if(UNDOAC == 0) {
				System.out.println("ENDOF STACK");
				return;
			}
			System.out.println("REDONE");
			UNDOAC -= 1;
			SSindex += 1;
			for(int i = 0; i < 500; i++) {
				try {
					try {
						if(SS[i][SSindex].getType().equals("Comissionado")) {
							teste[i] = new Comissionado();
						}if(SS[i][SSindex].getType().equals("Horista")) {
							teste[i] = new Horista();
						}if(SS[i][SSindex].getType().equals("Assalariado")) {
							teste[i] = new Assalariado();
						}
						CalendarMT.payboo[CalendarMT.DAYSGONE] = SS[i][SSindex].isPayboo();
						teste[i].setAgendaToString(SS[i][SSindex].getAgendaToString());
						teste[i].setName(SS[i][SSindex].getName());
						teste[i].setSalary(SS[i][SSindex].getSalary());
						teste[i].setAdress(SS[i][SSindex].getAdress());
						teste[i].setPayMode(SS[i][SSindex].getPayMode());
						teste[i].setType(SS[i][SSindex].getType());
						teste[i].setSindicaty(SS[i][SSindex].isSindicaty());
						teste[i].setCode(SS[i][SSindex].getCode());
						teste[i].setSindicatycode(SS[i][SSindex].getScode());
						teste[i].setSaved(SS[i][SSindex].isSaved());
						teste[i].setCheckIN(SS[i][SSindex].isCheckIN());
						teste[i].setCheckOUT(SS[i][SSindex].isCheckOUT());
						teste[i].setCustom(SS[i][SSindex].isCustom());
						teste[i].setFrequenciaD(SS[i][SSindex].getFrequenciaD());
						teste[i].setSalarybup(SS[i][SSindex].getSalarybup());
						if(teste[i] instanceof Horista) {
							((Horista) teste[i]).setSalarioBase(SS[i][SSindex].getSalarioBase());
							((Horista) teste[i]).setPsalary(SS[i][SSindex].getPsalary());
							
						}
						if(teste[i] instanceof Comissionado) {
							((Comissionado) teste[i]).setBonussalary(SS[i][SSindex].getBonussalary());
							((Comissionado) teste[i]).setPVenda(SS[i][SSindex].getPVenda());
							((Comissionado) teste[i]).setPsalary(SS[i][SSindex].getPsalary());
						}
						if(teste[i] instanceof Assalariado) {
							((Assalariado) teste[i]).setPsalary(SS[i][SSindex].getPsalary());
						}
						teste[i].setAgenda(SS[i][SSindex].getAgenda());
						teste[i].setAgendaID(SS[i][SSindex].getAgendaID());
						}
						catch(Exception ex) {
							System.err.print(ex);
						}
					}
				catch(Exception ex) {
					System.err.print(ex);
				}
			}
		} catch(Exception ex2) {
			System.out.println(ex2.getMessage());
			JOptionPane.showMessageDialog(null ,
					"Não há ações para refazer", "End of Stack!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}

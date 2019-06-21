package com.payroll;

import javax.swing.JOptionPane;

public class Command {
	
	static int SSindex = 0;
	static int UNDOAC = 0;
	static int AgendaIndex = 0;
	static SaveState[][] SS = new SaveState[50][50];
	
	static void saveS(Funcionario[] func) {
		
    	SSindex += 1;
    	for(int i = 0; i < 50; i++) {
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
				if(func[i] instanceof Horista) {
					SS[i][SSindex].setSalarioBase(((Horista) func[i]).getSalarioBase());
					SS[i][SSindex].setPday(((Horista) func[i]).getPday());
				}
				if(func[i] instanceof Assalariado) {
					SS[i][SSindex].setPayday(((Assalariado) func[i]).getPayday());
				}
				if(func[i] instanceof Comissionado) {
					SS[i][SSindex].setPday(((Comissionado) func[i]).getPday());
				}
				
			}
			
		}
    	
	}
	static void undo(Funcionario[] teste){
		try {
			if(SSindex == 1) {
				throw new Exception("EMPTY STACK");
			}
			System.out.println("undo");
			UNDOAC += 1;
			SSindex -= 1;
			for(int i = 0; i < 50; i++) {
				if(teste[i] != null) {
					
					
					if(SS[i][SSindex].getType().equals("Comissionado")) {
						teste[i] = new Comissionado();
					}if(SS[i][SSindex].getType().equals("Horista")) {
						teste[i] = new Horista();
					}if(SS[i][SSindex].getType().equals("Assalariado")) {
						teste[i] = new Assalariado();
					}
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
					if(teste[i] instanceof Horista) {
						((Horista) teste[i]).setSalarioBase(SS[i][SSindex].getSalarioBase());
						((Horista) teste[i]).setPday(SS[i][SSindex].getPday());
					}
					if(teste[i] instanceof Assalariado) {
						((Assalariado) teste[i]).setPayday(SS[i][SSindex].getPayday());
					}
					if(teste[i] instanceof Comissionado) {
						((Comissionado) teste[i]).setPday(SS[i][SSindex].getPday());
					}
					
				}
			}
		} catch(Exception ex2) {
			System.out.println(ex2.getMessage());
			JOptionPane.showMessageDialog(null ,
					"Não há ações para desfazer", "Empty Stack!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	static void redo(Funcionario[] teste){
		try {
			if(UNDOAC == 0) {
				throw new Exception("EMPTY STACK");
			}
			System.out.println("redo");
			UNDOAC -= 1;
			SSindex += 1;
			for(int i = 0; i < 50; i++) {
				if(teste[i] != null) {
					
					if(SS[i][SSindex].getType().equals("Comissionado")) {
						teste[i] = new Comissionado();
					}if(SS[i][SSindex].getType().equals("Horista")) {
						teste[i] = new Horista();
					}if(SS[i][SSindex].getType().equals("Assalariado")) {
						teste[i] = new Assalariado();
					}
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
					if(teste[i] instanceof Horista) {
						((Horista) teste[i]).setSalarioBase(SS[i][SSindex].getSalarioBase());
						((Horista) teste[i]).setPday(SS[i][SSindex].getPday());
					}
					if(teste[i] instanceof Assalariado) {
						((Assalariado) teste[i]).setPayday(SS[i][SSindex].getPayday());
					}
					if(teste[i] instanceof Comissionado) {
						((Comissionado) teste[i]).setPday(SS[i][SSindex].getPday());
					}
					
				}
			}
		} catch(Exception ex2) {
			System.out.println(ex2.getMessage());
			JOptionPane.showMessageDialog(null ,
					"Não há ações para refazer", "End of Stack!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}

package com.payroll;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Utility {
	

	public int findIndex(Funcionario[] func) {
		for(int i = 0; i < 50; i++)
		{
			if(!func[i].isSaved())
			{
				return i;
			}
		}
		return -1;
		
	}
	 
	public void setALL(Funcionario[] func, Agenda[] agenda) {
		for(int i = 0; i < 50; i++)
		{
			func[i] = new Horista();
			agenda[i] = new Agenda();
			agenda[i].setSaved(false);
		}
	}
	
	public void setList(Funcionario[] teste, DefaultListModel DLMC, DefaultListModel DLMA, DefaultListModel DLMH) {
		for(int i = 0; i < 50; i++) { 
			if(teste[i].isSaved())
			{
				if(teste[i].getType().equals("Assalariado")){
					DLMA.addElement(teste[i].getName() + " - " + teste[i].getCode());	
				}if(teste[i].getType().equals("Comissionado") && teste[i].isSaved() ){
					DLMC.addElement(teste[i].getName() + " - " + teste[i].getCode());	
				}if(teste[i].getType().equals("Horista") && teste[i].isSaved()){
					DLMH.addElement(teste[i].getName() + " - " + teste[i].getCode());	
				}
			}
			
		}
	}
	public void ERRO() {
		JOptionPane.showMessageDialog(null ,
				"Preencha todos os campos corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
	}

}

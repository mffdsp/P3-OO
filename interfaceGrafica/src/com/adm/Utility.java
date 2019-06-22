package com.adm;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;
import com.schedule.Agenda;

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
			func[i].setType("Horista");
			CalendarMT.payboo[i] = false;
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
	
	public void payList(Funcionario[] teste, DefaultListModel DLMC, DefaultListModel DLMA, DefaultListModel DLMH) {
		for(int i = 0; i < 50; i++) { 
			if(teste[i].isSaved())
			{
				if(teste[i] instanceof Assalariado && ((Assalariado)teste[i]).pagarFuncionario()){
					
					DLMA.addElement(teste[i].toString());	
					
				}if(teste[i] instanceof Comissionado && ((Comissionado)teste[i]).pagarFuncionario()){
					
					((Comissionado)teste[i]).setRealSalary(teste[i].getSalary());
					DLMC.addElement(teste[i].toString());	
					
				}if(teste[i] instanceof Horista && ((Horista)teste[i]).pagarFuncionario()){
					
					DLMH.addElement(teste[i].toString());	
					
				}
			}
			
		}
	}
	
	public void ERRO() {
		JOptionPane.showMessageDialog(null ,
				"Preencha todos os campos corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
	}

}

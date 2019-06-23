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
		for(int i = 0; i < 500; i++)
		{
			if(!func[i].isSaved())
			{
				return i;
			}
		}
		return -1;
		
	}
	 
	public int getIndex(String codigo){
        int i = 0;
        int index = 0;
        //2019265
        int pt = codigo.length() - 5;
        while(i < codigo.length() - 4 )
        {
            index += Math.pow(10, pt - i) * Character.getNumericValue(codigo.charAt(i + 4));
            i += 1;
        }
        return index;
	}
	
	public boolean isFree(Funcionario[] func, String newScode) {
		for(int i = 0; i < 500; i++)
		{
			if(func[i].getSindicatycode().equals(newScode) && func[i].isSindicaty() && func[i].isSaved())
			{
				return false;
			}
		}
		return true;
	}
	
	public int findFuncSind(Funcionario[] func, String newScode) {
		for(int i = 0; i < 500; i++)
		{
			if(func[i].getSindicatycode().equals(newScode) && func[i].isSindicaty() && func[i].isSaved())
			{
				return i;
			}
		}
		return -1;
	}
	
	public void setALL(Funcionario[] func, Agenda[] agenda) {
		for(int i = 0; i < 500; i++)
		{
			try {
				
				func[i] = new Horista();
				func[i].setType("Horista");
				CalendarMT.payboo[i] = false;
				agenda[i] = new Agenda();
				agenda[i].setSaved(false);
				
			}catch(Exception e){
				System.err.println(e);
			}
			
		}
	}
	
	public void setList(Funcionario[] teste, DefaultListModel DLMC, DefaultListModel DLMA, DefaultListModel DLMH) {
		for(int i = 0; i < 500; i++) { 
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
		for(int i = 0; i < 500; i++) { 
			if(teste[i].isSaved())
			{
				if(teste[i] instanceof Assalariado && ((Assalariado)teste[i]).pagarFuncionario()){
					
					DLMA.addElement(teste[i].toString());	
					
				}if(teste[i] instanceof Comissionado && ((Comissionado)teste[i]).pagarFuncionario()){
					
					DLMC.addElement(teste[i].toString());	
					((Comissionado)teste[i]).setPsalary(((Comissionado)teste[i]).getRealSalary());
					((Comissionado)teste[i]).setRealSalary(-((Comissionado)teste[i]).getRealSalary() + teste[i].getSalary()/2);
					
				}if(teste[i] instanceof Horista && ((Horista)teste[i]).pagarFuncionario()){
					
					DLMH.addElement(teste[i].toString());
					((Horista)teste[i]).setPsalary(((Horista)teste[i]).getSalary());
					teste[i].setSalary(((Horista)teste[i]).getSalarioBase());
					
				}
			}
			
		}
	}
	
	public void ERRO() {
		JOptionPane.showMessageDialog(null ,
				"Preencha todos os campos corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
	}

}

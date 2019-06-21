package com.payroll;

import java.util.Date;

public class Assalariado extends Funcionario implements SystemMT{

	
	private int payday;
	
	public int getPayday() {
		return payday;
	}

	public void setPayday(int payday) {
		this.payday = payday;
	}

	@Override
	public boolean pagarFuncionario() {
		// TODO Auto-generated method stub
		return false;
	}

}

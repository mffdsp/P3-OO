package com.adm;

import com.schedule.Agenda;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class SaveState{

	private String name;
	private String adress;
	private double salary;
	private double realSalary = 0;
	private double salarybup = 0;
	private double psalary = 0;
	private double bonussalary = 0;
	private String payMode;
	private String type;
	public int DtInicial;
	private boolean sindicaty;
	private String code;
	private String Scode;
	private boolean saved = false;
	private boolean checkIN = false;
	private boolean checkOUT = false;
	private double salarioBase = 0; 
	private boolean Asaved = false;
	private int Aindex = 0;
	private boolean custom = false;
	private String pday = "Sexta-Feira"; 
	private int payday = 30; 
	private String agendaToString = "default"; 
	private boolean[] payboo = new boolean[500];
	private int pvenda = 15;
	Agenda agenda = new Agenda();
	private String weekdia = "Sexta-Feira";
	private int agendaID = 0;
	private int passouD = 0;
	private int frequenciaD = 30; 
	private boolean URpago = false;
	
	
	public void setAgenda(Agenda agenda) {
		if(agenda instanceof Mensal) {
			this.agenda = new Mensal();
			this.agenda.setFrequencia(agenda.getFrequencia());
			((Mensal)this.agenda).setDia(((Mensal) agenda).getDia());
		}
		if(agenda instanceof Semanal) {
			this.agenda = new Semanal();
			this.agenda.setFrequencia(agenda.getFrequencia());
			((Semanal)this.agenda).setDia((((Semanal) agenda).getDia()));
		}
	}
	public Agenda getAgenda() {
		return this.agenda;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isSindicaty() {
		return sindicaty;
	}
	public void setSindicaty(boolean sindicaty) {
		this.sindicaty = sindicaty;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getScode() {
		return Scode;
	}
	public void setScode(String scode) {
		Scode = scode;
	}
	public boolean isSaved() {
		return saved;
	}
	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	public boolean isCheckIN() {
		return checkIN;
	}
	public void setCheckIN(boolean checkIN) {
		this.checkIN = checkIN;
	}
	public boolean isCheckOUT() {
		return checkOUT;
	}
	public void setCheckOUT(boolean checkOUT) {
		this.checkOUT = checkOUT;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public boolean isAsaved() {
		return Asaved;
	}
	public void setAsaved(boolean asaved) {
		Asaved = asaved;
	}
	public int getAindex() {
		return Aindex;
	}
	public void setAindex(int aindex) {
		Aindex = aindex;
	}
	public boolean isCustom() {
		return custom;
	}
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
	public int getPayday() {
		return payday;
	}
	public void setPayday(int payday) {
		this.payday = payday;
	}
	public String getPday() {
		return pday;
	}
	public void setPday(String pday) {
		this.pday = pday;
	}
	public String getAgendaToString() {
		return agendaToString;
	}
	public void setAgendaToString(String agendaToString) {
		this.agendaToString = agendaToString;
	}
	public boolean isPayboo() {
		return payboo[CalendarMT.DAYSGONE];
	}
	public void setPayboo(boolean payboo) {
		this.payboo[CalendarMT.DAYSGONE] = payboo;
	}
	public int getPVenda() {
		return pvenda;
	}
	public void setPVenda(int pvenda) {
		this.pvenda = pvenda;
	}
	public String getWeekdia() {
		return weekdia;
	}
	public void setWeekdia(String weekdia) {
		this.weekdia = weekdia;
	}
	public int getAgendaID() {
		return agendaID;
	}
	public void setAgendaID(int agendaID) {
		this.agendaID = agendaID;
	}
	public int getFrequenciaD() {
		return frequenciaD;
	}
	public void setFrequenciaD(int frequenciaD) {
		this.frequenciaD = frequenciaD;
	}
	public int getPassouD() {
		return passouD;
	}
	public void setPassouD(int passouD) {
		this.passouD = passouD;
	}
	public double getRealSalary() {
		return realSalary;
	}
	public void setRealSalary(double realSalary) {
		this.realSalary += realSalary;
	}
	public boolean isURpago() {
		return URpago;
	}
	public void setURpago(boolean uRpago) {
		URpago = uRpago;
	}
	public double getSalarybup() {
		return salarybup;
	}
	public void setSalarybup(double salarybup) {
		this.salarybup = salarybup;
	}
	public double getPsalary() {
		return psalary;
	}
	public void setPsalary(double psalary) {
		this.psalary = psalary;
	}
	public double getBonussalary() {
		return bonussalary;
	}
	public void setBonussalary(double bonussalary) {
		this.bonussalary = bonussalary;
	}

}

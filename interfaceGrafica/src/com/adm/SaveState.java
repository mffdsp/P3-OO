package com.adm;


public class SaveState{

	private String name;
	private String adress;
	private double salary;
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
	private int dia = 0;
	private int frequencia = 0;
	private String weekdia = "Sexta-Feira";

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
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	public String getWeekdia() {
		return weekdia;
	}
	public void setWeekdia(String weekdia) {
		this.weekdia = weekdia;
	}
	

}

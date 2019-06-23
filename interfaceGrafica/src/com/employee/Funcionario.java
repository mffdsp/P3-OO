package com.employee;

import com.schedule.Agenda;
import com.schedule.Mensal;
import com.schedule.Semanal;

public abstract class Funcionario{
	 
	//base
	protected String name;
	protected String adress;
	protected double salary;
	protected String payMode;
	protected String type;
	protected String code;
	protected boolean saved = false; 
	//Syndicate
	protected boolean sindicaty = false;
	protected String Scode = "notset";
	//Timecard
	private boolean pago = false;
	protected int timeIN = 0;
	protected int timeOUT = 0;
	private boolean checkIN = false;
	private boolean checkOUT = false;
	//Schedule
	Agenda agenda = new Agenda();
	private boolean custom = false;
	private String shtype = "Mensal";
	private int agendaID = -1; 
	private String agendaToString = "default";
	
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
	public void setTimeIN(int timeIN){
		this.timeIN = timeIN;
	}
	public void setTimeOUT(int timeOUT){
		this.timeOUT = timeOUT;
	}
	public int getTimeIN(){
		return timeIN;
	}
	public int getTimeOUT(){
		return timeOUT;
	}
	public String toString() {
		return name + " / " + code +  " / " + salary + "RS";
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public boolean isSindicaty() {
		return sindicaty;
	}
	public void setSindicaty(boolean sindicaty) {
		this.sindicaty = sindicaty;
	}
	
	public void setCode(String code) {
		this.code = code;
		
	}
	public String getCode() {
		return this.code;
	}
	public void setSindicatycode(String Scode) {
		this.Scode = Scode;
	}
	public String getSindicatycode() {
		return this.Scode;
	}
	public boolean isSaved() {
		return saved;
	}
	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	public boolean isCheckOUT() {
		return checkOUT;
	}
	public void setCheckOUT(boolean checkOUT) {
		this.checkOUT = checkOUT;
	}
	public boolean isCheckIN() {
		return checkIN;
	}
	public void setCheckIN(boolean checkIN) {
		this.checkIN = checkIN;
	}
	public boolean isCustom() {
		return custom;
	}
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
	public int getAgendaID() {
		return agendaID;
	}
	public void setAgendaID(int agendaID) {
		this.agendaID = agendaID;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	public String getAgendaToString() {
		return agendaToString;
	}
	public void setAgendaToString(String agendaToString) {
		this.agendaToString = agendaToString;
	}
	public String getShtype() {
		return shtype;
	}
	public void setShtype(String shtype) {
		this.shtype = shtype;
	}
}



















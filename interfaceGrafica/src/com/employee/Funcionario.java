package com.employee;


public abstract class Funcionario{
	 
	protected String name;
	protected String adress;
	protected double salary;
	protected String payMode;
	protected String type;
	protected int DtInicial;
	protected boolean sindicaty = false;
	protected String code;
	protected String Scode;
	protected boolean saved = false; 
	protected int timeIN = 0;
	protected int timeOUT = 0;
	protected int WH = 0;
	private boolean pago = false;
	private boolean checkIN = false;
	private boolean checkOUT = false;
	private boolean custom = false;
	private int agendaID = -1; 
	private String agendaToString = "default";
	
	public void setWH(int WH){
		this.WH += WH;
	}
	public int getWH(){
		return WH;
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
}



















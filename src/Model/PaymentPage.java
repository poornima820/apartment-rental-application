package Model;

import java.util.ArrayList;

import Model.CustomerPage;

public class PaymentPage extends User {
	String cc_Name;
	public String getCc_Name() {
		return cc_Name;
	}
	public void setCc_Name(String cc_Name) {
		this.cc_Name = cc_Name;
	}
	public double getCc_No() {
		return cc_No;
	}
	public void setCc_No(double cc_No) {
		this.cc_No = cc_No;
	}
	public String getCc_Type() {
		return cc_Type;
	}
	public void setCc_Type(String cc_Type) {
		this.cc_Type = cc_Type;
	}
	public int getCc_Cvv() {
		return cc_Cvv;
	}
	public void setCc_Cvv(int cc_Cvv) {
		this.cc_Cvv = cc_Cvv;
	}
	public String getCc_Exp() {
		return cc_Exp;
	}
	public void setCc_Exp(String cc_Exp) {
		this.cc_Exp = cc_Exp;
	}
	public ArrayList<CustomerPage> getCustomer() {
		return customer;
	}
	public void setCustomer(ArrayList<CustomerPage> customer) {
		this.customer = customer;
	}
	double cc_No;
	String cc_Type;
	int cc_Cvv;
	String cc_Exp;
	private ArrayList<CustomerPage> customer;
	public PaymentPage()
	{
		
	}
	public PaymentPage(String cc_Name, int cc_No, String cc_Type, int cc_Cvv, String cc_Exp)
	{
		this.cc_Name = cc_Name;
		this.cc_No = cc_No;
		this.cc_Cvv = cc_Cvv;
		this.cc_Exp = cc_Exp;
		
		
	}
	

}

package Model;

import java.util.ArrayList;

import Model.Apartment;

public class CustomerPage extends User {
	private String last_Name;
	private String ph_Num;
	private ArrayList<Apartment> apartment;
	private String user_Name;
	private String pass_word;
	private String first_Name;
	private String emailID;
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getPh_Num() {
		return ph_Num;
	}
	public void setPh_Num(String ph_Num) {
		this.ph_Num = ph_Num;
	}
	public ArrayList<Apartment> getApartment() {
		return apartment;
	}
	public void setApartment(ArrayList<Apartment> apartment) {
		this.apartment = apartment;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	
}

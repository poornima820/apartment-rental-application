package Model;

public class Apartment {
	String aptID;
	String aptType;
	double aptRent;
	//String aptAddress;
	public Apartment(){
		
	}
	public Apartment(String aptID, String aptType, Double aptRent)
	{
		this.aptID = aptID;
		this.aptType = aptType;
		this.aptRent = aptRent;
		//this.aptAddress = aptAddress;
		
	}
	public String getAptID() {
		return aptID;
	}
	public void setAptID(String aptID) {
		this.aptID = aptID;
	}
	public String getAptType() {
		return aptType;
	}
	public void setAptType(String aptType) {
		this.aptType = aptType;
	}
	public Double getAptRent() {
		return aptRent;
	}
	public void setAptRent(Double aptRent) {
		this.aptRent = aptRent;
	}
/*	public String getAptAddress() {
		return aptAddress;
	}
	public void setAptAddress(String aptAddress) {
		this.aptAddress = aptAddress;
	}*/
	
}

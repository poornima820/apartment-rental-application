package Model;

import javafx.beans.property.SimpleStringProperty;

public class Bookings {
	private String bookingId;
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAptId() {
		return aptId;
	}
	public void setAptId(String aptId) {
		this.aptId = aptId;
	}
	public String getAptType() {
		return aptType;
	}
	public void setAptType(String aptType) {
		this.aptType = aptType;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getMoveoutDate() {
		return moveoutDate;
	}
	public void setMoveoutDate(String moveoutDate) {
		this.moveoutDate = moveoutDate;
	}
	public String getTotalRent() {
		return totalRent;
	}
	public void setTotalRent(String totalRent) {
		this.totalRent = totalRent;
	}
	public SimpleStringProperty getAptID1() {
		return aptID1;
	}
	public void setAptID1(SimpleStringProperty aptID1) {
		this.aptID1 = aptID1;
	}
	public SimpleStringProperty getAptType1() {
		return aptType1;
	}
	public void setAptType1(SimpleStringProperty aptType1) {
		this.aptType1 = aptType1;
	}
	private String customerId;
	private String aptId;
	private String aptType;
	private String rentDate;
	private String moveoutDate;
	private String totalRent;
	public SimpleStringProperty aptID1= new SimpleStringProperty();
	public SimpleStringProperty aptType1=new SimpleStringProperty();
}

package com.revature.config.model;
import java.sql.Timestamp;


public class Reservation {

	private int seatno;
	private String berth;
	private String status;
	private String regno;
	private String firstname;
	private String lastname;
	private int age;
	private  String src;
	private Timestamp arrival;
	private int charge;
	private Timestamp boardingtime;
	private String uid;
	private Timestamp reserveddate;
	
	
	public  Reservation(){
		super();
	}
	public Reservation(int seatno, String berth, String status, String regno) {
		super();
		this.seatno = seatno;
		this.berth = berth;
		this.status = status;
		this.regno = regno;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getBerth() {
		return berth;
	}
	public void setBerth(String berth) {
		this.berth = berth;
	}
	@Override
	public String toString() {
		return "Reservation [seatno=" + seatno + ", berth=" + berth + ", status=" + status + ", regno=" + regno + "]";
	}
	

}

package com.revature.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.application.ReservationMenu;
import com.revature.config.DatabaseConnection;
import com.revature.config.model.Reservation;
import com.revature.constants.Constant;
import com.revature.dao.ReservationI;

public class ReservationImp implements ReservationI {
	Logger logger = Logger.getLogger(ReservationMenu.class.getName());
	private Connection con = DatabaseConnection.getConnection();
	Scanner scan = new Scanner(System.in);
	

	
	@Override
	public void Reservationn() throws SQLException {
		
		// TODO Auto-generated method stub
		CallableStatement cs2= con.prepareCall("{ call searchroute(?,?)}");
		Reservation r1 =  new Reservation();
		
		logger.info(Constant.src);
		String s=scan.nextLine();
		cs2.setString(1, s);
		scan.nextLine();
		logger.info(Constant.desti);
		String ss= scan.nextLine();
		cs2.setString(2, ss);
		ResultSet rs1=cs2.executeQuery();
		while(rs1.next())
		{
			logger.info(rs1.getString(1)+"| "+ rs1.getString(2)+" |"+rs1.getString(3)+" |"+rs1.getTimestamp(4)+" |"+rs1.getTimestamp(5)+" |"+rs1.getInt(6));
		}
		
		
		CallableStatement cs3 = con.prepareCall("{ call option2(?)}");
		logger.info(Constant.reg);
		String regno=scan.nextLine();
		cs3.setString(1, regno);
		ResultSet rs=cs3.executeQuery();
		while(rs.next())
		{
			logger.info(rs.getInt(1)+"| "+rs.getString(2)+" |"+rs.getString(3)+" |"+rs.getString(4));
		}
		
		CallableStatement cs4 =con.prepareCall("{call booking(?,?)}");
		
		logger.info(Constant.seatno);
		int seatno=Integer.parseInt(scan.nextLine());
		cs4.setInt(1, seatno);
		cs4.setString(2, regno);
		cs4.executeUpdate();
		
		CallableStatement cs5 =con.prepareCall("{call final(?,?)}");
		logger.info("enter yes if you want to book");
		String w = scan.nextLine();
		if(w.equalsIgnoreCase("yes"))
		{
		cs5.setString(1, regno);
		cs5.setInt(2, seatno);
		ResultSet rrs= cs5.executeQuery();
		while (rrs.next())
		{
			logger.info("NAME:"+ rrs.getString(1)+" |MAILID:"+rrs.getString(2)+" |BERTH:"+rrs.getString(3)+" |SEATNO:"+rrs.getInt(4)+" |BOARDING PLACE:"+rrs.getString(5)+" |DESTINATION:"+rrs.getString(6)+" |BOARDING TIME"+rrs.getTimestamp(7)+" |ARRIVAL TIME"+rrs.getTimestamp(8)+" |UID"+rrs.getString(9)+" |STATUS"+rrs.getTimestamp(10)+" |"+rrs.getString(11));
		}
		logger.info("successfully booked");
		}
		else
		{
			logger.info("booking cancelled");
		}
		
		
//		//java.sql.CallableStatement cs;
//		String insertqueryt="seatlayout";
//		//PreparedStatement preparedStatement  = con.prepareStatement(insertquery);\
//		cs=con.prepareCall("{call buslayoutt()}");
//		ResultSet rs=cs.executeQuery();
//		while(rs.next())
//		{
//			logger.info("seatno  : "+rs.getInt(1)+"| "+"berth  :"+rs.getString(2)+"| "+"status :"+rs.getString(3)+"| "+" regno  :"+rs.getString(4));
//		}
//
//
//		CallableStatement cs1=con.prepareCall("{call insertbusmap(?,?,?,?)}");
//		Reservation r =  new Reservation();
//		logger.info("enter the seat no");
//		int seat=scan.nextInt();
//		
//		cs1.setInt(1, seat);
//		logger.info("enter the berth");
//		cs1.setString(2, r.getBerth());
//		r.setStatus("AVAIABLE");
//		cs1.setString(3, r.getStatus());
//		r.setRegno("AB-999");
//		cs1.setString(4, r.getRegno());
//		cs1.executeUpdate();
//			

		
		
	}



	@Override
	public void viewTicket() throws SQLException {
		CallableStatement cs = con.prepareCall("{call viewticket(?,?)}");
		logger.info(Constant.reg);
		String setn=scan.nextLine();
		logger.info(Constant.uid);
		String uid=scan.nextLine();
		cs.setString(1, setn);
		cs.setString(2, uid);
		ResultSet rrs= cs.executeQuery();
		while(rrs.next())
		{
			logger.info("NAME:"+ rrs.getString(1)+" |MAILID:"+rrs.getString(2)+" |BERTH:"+rrs.getString(3)+" |SEATNO:"+rrs.getInt(4)+" |BOARDING PLACE:"+rrs.getString(5)+" |DESTINATION:"+rrs.getString(6)+" |BOARDING TIME"+rrs.getTimestamp(7)+" |ARRIVAL TIME"+rrs.getTimestamp(8)+" |UID  :"+rrs.getString(9)+" |STATUS"+rrs.getTimestamp(10)+" |"+rrs.getString(11));
		}
		
		
	}
	}
	

	

	



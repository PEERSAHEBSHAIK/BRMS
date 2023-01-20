package com.revature.application;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.constants.Constant;
import com.revature.dao.impl.ReservationImp;

public class ReservationMenu {
	public static void main(String[] args) {
	Logger logger = Logger.getLogger(ReservationMenu.class.getName());
	ReservationImp reservation = new ReservationImp();
	Scanner scan = new Scanner(System.in);
	int n;
	do{
		logger.info(Constant.reserv);
		logger.info(Constant.viewTicket);
		logger.info(Constant.exit);
		 n=scan.nextInt();
		switch(n)
		{
		   case 1:
			   try{
				reservation.Reservationn();
				break;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			case 2:
			try {
				reservation.viewTicket();
				break;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			case 3:
			break;
			default :
				logger.info(Constant.enterBetween);
				break;
			case 4:
				logger.info(Constant.exit);
				return;
		}
	}while(true);
	
}
}


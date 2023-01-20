package com.revature.config.model;

public class Trip {
		private String source ;
		private String destination;
		private String busRegno;
		private String boardingTime;
		private String arrivaltime;
		public Trip()
		{
			super();
		}
		public Trip(String source ,String destination,String busRegno,String boardingTime, String arrivaltime)
		{
			this.source=source;
			this.destination=destination;
			this.busRegno=busRegno;
			this.boardingTime=boardingTime;
			this.arrivaltime=arrivaltime;
		}
		public String getSource() {
			return destination;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public String getBusRegno() {
			return busRegno;
		}
		public void setBusRegno(String busRegno) {
			this.busRegno = busRegno;
		}
		public String getBoardingTime() {
			return boardingTime;
		}
		public void setBoardingTime(String boardingTime) {
			this.boardingTime = boardingTime;
		}
		public String getArrivalTime() {
			return arrivaltime;
		}
		public void setArrivaltime(String t1) {
			this.arrivaltime = arrivaltime;
		}
		public String toString()
		{
			return busRegno+" "+destination+" "+destination+" "+arrivaltime+" "+boardingTime;
		}

}

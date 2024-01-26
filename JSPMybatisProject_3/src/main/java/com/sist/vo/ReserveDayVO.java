package com.sist.vo;
/*
 *   TNO                                       NOT NULL NUMBER
 TIME                                      NOT NULL VARCHAR2(10)
 * 
 */


public class ReserveDayVO {
	private int rno;
	private String rtime;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRtime() {
		return rtime;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	
}

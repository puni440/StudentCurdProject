package com.jdbc.model;

public class Student {

	private int Sid;
	private String Sname;
	private String Semister;
	private double CGP;
	private String Complaint;

	public String getComplaint() {
		return Complaint;
	}

	public void setComplaint(String complaint) {
		Complaint = complaint;
	}

	public Student(int sid, String complaint) {
		super();
		Sid = sid;
		Complaint = complaint;
	}

	public Student(int sid, String sname, String semister, double cGP, String complaint) {
		super();
		Sid = sid;
		Sname = sname;
		Semister = semister;
		CGP = cGP;
		Complaint = complaint;
	}

	public Student(String sname, String semister, double cGP) {
		super();
		Sname = sname;
		Semister = semister;
		CGP = cGP;
	}

	public Student(int sid, String sname, String semister, double cGP) {
		super();
		Sid = sid;
		Sname = sname;
		Semister = semister;
		CGP = cGP;
	}

	public int getSid() {
		return Sid;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSemister() {
		return Semister;
	}

	public void setSemister(String semister) {
		Semister = semister;
	}

	public double getCGP() {
		return CGP;
	}

	public void setCGP(double cGP) {
		CGP = cGP;
	}
}

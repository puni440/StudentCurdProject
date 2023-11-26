package com.jdbc.util;

public class QueryUtil {

	public static String insertStudentQuery() {

		return "INSERT INTO STUDENT_INFO (STUDENT_ID,STUDENT_NAME,STUDENT_SEMISTER,STUDENT_CGP) VALUES(?,?,?,?)";
	}

	public static String viewAllStudentQuery() {

		return "SELECT * FROM STUDENT_INFO,STUDENT_COMPLAINT";
	}

	public static String viewStudentQuery(int studentid) {

		return "SELECT * FROM STUDENT_INFO,STUDENT_COMPLAINT WHERE STUDENT_INFO.STUDENT_ID = " + studentid;
	}

	public static String deleteStudentById(int id) {

		return "DELETE FROM STUDENT_INFO WHERE STUDENT_ID = " + id;
	}

	public static String editStudentQuery(int id) {

		return "UPDATE STUDENT_INFO SET STUDENT_NAME = ?, STUDENT_SEMISTER = ?,STUDENT_CGP = ? WHERE STUDENT_ID = "
				+ id;
	}

	public static String complaintStudentQuery() {

		return ("INSERT INTO STUDENT_COMPLAINT (STUDENT_ID,COMPLAINT) VALUES(?,?)");

	}

}

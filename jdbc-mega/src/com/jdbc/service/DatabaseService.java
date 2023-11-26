package com.jdbc.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.model.Student;
import com.jdbc.util.DatabaseUtil;
import com.jdbc.util.QueryUtil;

public class DatabaseService {

	static DatabaseUtil databaseUtil = new DatabaseUtil();

	public void insertStudent(Student student) throws SQLException {

		try (Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertStudentQuery());) {

			preparedStatement.setInt(1, student.getSid());
			preparedStatement.setString(2, student.getSname());
			preparedStatement.setString(3, student.getSemister());
			preparedStatement.setDouble(4, student.getCGP());

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {
				System.out.println("\n\n--Record created successfully.--");
			} else {
				System.out.println("\n\n.....Insert record failed.....");
			}

		}
	}// End of insertStudent();

	public void viewALlStudent() throws SQLException {
		try (Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QueryUtil.viewAllStudentQuery());) {

			while (resultSet.next()) {

				printStudent(new Student(resultSet.getInt("STUDENT_ID"), resultSet.getString("STUDENT_NAME"),
						resultSet.getString("STUDENT_SEMISTER"), resultSet.getDouble("STUDENT_CGP"),resultSet.getString("COMPLAINT")));
			}

		}
	}// end of viewAllStudent()

	private void printStudent(Student student) {
		System.out.println("\n\n          :-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-:\n");
		System.out.println("          Student ID :- " + student.getSid());
		System.out.println("          Student Name :- " + student.getSname());
		System.out.println("          Student Semister :- " + student.getSemister());
		System.out.println("          Student CGP :- " + student.getCGP());
		System.out.println("          Student Complaint :-"+student.getComplaint());
		System.out.println("\n          :-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-:\n\n");
	}// end of printStudent();

	public boolean viewStudentById(int id) throws SQLException {

		boolean isFound = false;

		try (Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QueryUtil.viewStudentQuery(id));) {

			if (resultSet.next()) {
				isFound = true;
				printStudent(new Student(resultSet.getInt("STUDENT_ID"), resultSet.getString("STUDENT_NAME"),
						resultSet.getString("STUDENT_SEMISTER"), resultSet.getDouble("STUDENT_CGP"),resultSet.getString("COMPLAINT")));
			} else {
				System.out.println("\n\n     .....Record not found for :" + id + ".....");
			}

		}
		return isFound;
	}// end of viewStudentById();


	public void deleteStudentById(int studentid) throws SQLException {

		try (Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement();) {
			int rows = statement.executeUpdate(QueryUtil.deleteStudentById(studentid));

			if (rows > 0) {
				System.out.println("\n\n     -----Record deleted successfully-----");
			} else {
				System.out.println("\n\n     .....Somthing went wrong.....");
			}
		}

	}// end of deleteStudentById()

	public void editStudent(Student student) throws SQLException {

		try (Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(QueryUtil.editStudentQuery(student.getSid()))) {
			preparedStatement.setString(1, student.getSname());
			preparedStatement.setString(2, student.getSemister());
			preparedStatement.setDouble(3, student.getCGP());

			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("\n\n     ------Record Edited successfully-----");
			} else {
				System.out.println("\n\n     .....Failed to update recored ......");
			}

		}

	}// end of editStudent();

	public void complaintStudent(Student student) throws SQLException {

		try (Connection connection = databaseUtil.getConnection();
				// System.out.println(student.getSid());
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.complaintStudentQuery())) {
			preparedStatement.setInt(1, student.getSid());
			preparedStatement.setString(2, student.getComplaint());

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {
				System.out.println("\n.....Complaint Raised......");
			} else {
				System.out.println("\n.....Failed To Complain.....");
			}

		}
	}// end

	public static void puni(Student student) throws SQLException {
		Connection connection = databaseUtil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertStudentQuery());

		preparedStatement.setInt(1, student.getSid());
		preparedStatement.setString(2, student.getSname());
		preparedStatement.setString(3, student.getSemister());
		preparedStatement.setDouble(4, student.getCGP());

		int rows = preparedStatement.executeUpdate();

		if (rows > 0) {
			System.out.println("\n\n--Record created successfully.--");
		} else {
			System.out.println("\n\n.....Insert record failed.....");
		}

	}//END
	
	
}

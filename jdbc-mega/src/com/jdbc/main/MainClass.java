package com.jdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.model.Student;
import com.jdbc.service.DatabaseService;

public class MainClass {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException {

		DatabaseService databaseService = new DatabaseService();
		Scanner scanner1 = new Scanner(System.in);
		try (Scanner scanner = new Scanner(System.in);) {

			boolean isRunning = true;
			boolean isStop = true;

			while (isStop) {

				System.out.print("\n     ( Admin or Student) :-  ");
				String str1 = scanner.next();

				if (str1.equals("Admin")) {

					while (isRunning) {
						System.out.println("\n         [_____1.INSERT_____]");
						System.out.println("         [_____2.DELETE_____]");
						System.out.println("         [_____3.EDIT  _____]");
						System.out.println("         [_____4.VIEW  _____]");
						System.out.println("         [_____5.EXIT  _____]");
						System.out.print("\n          Enter your choice :- ");

						int choice = scanner.nextInt();

						switch (choice) {
						case 1:

							System.out
									.println("     Enter The Details \n     Student:- ...Id ...Name...Cource...CGP...");
							int id = scanner.nextInt();
							String name = scanner1.nextLine();
							String course = scanner1.nextLine();
							double cgp = scanner.nextDouble();

							databaseService.insertStudent(new Student(id, name, course, cgp));

							break;

						case 2:

							System.out.print("\n     Enter The ID :- ");
							databaseService.deleteStudentById(scanner.nextInt());

							break;

						case 3:

							System.out.print("\n     Enter The ID :- ");
							int sid = scanner.nextInt();
							boolean isFound = databaseService.viewStudentById(sid);
							if (isFound) {
								System.out.println("\n     Enter The Name...Course...CGP");

								Student student = new Student(sid, scanner.next(), scanner.next(),
										scanner.nextDouble());
								databaseService.editStudent(student);

							}

							break;

						case 4:

							System.out.print("\n you want to display all Student records ? (YES/NO): :- ");
							String str2 = scanner.next();
							if (str2.equals("YES")) {
								databaseService.viewALlStudent();
							} else {
								System.out.print("\n     Enter Student ID :- ");
								databaseService.viewStudentById(scanner.nextInt());
							}

							break;

						case 5:

							System.out.println("\n*****[---Thak you. Visit Again.---]*****");
							isRunning = false;
							// isStop = false;

							break;

						default:

							System.out.println("\n     .....Incorrect choice..... ");
							break;
						}

					}
				} else if (str1.equals("Student")) {

					System.out.println("\n     WELCOME STUDENEDTS ");

					System.out.println("\n\n     Enter You ID :");
					int ID = scanner.nextInt();
					boolean b = true;

					while (b) {

						System.out.println("\n     [_____1.View    _____]");
						System.out.println("     [_____2.Complaint_____]");
						System.out.println("     [_____3.Exit     _____]");
						System.out.println("     Enter Your Choice : ");
						int choice = scanner.nextInt();

						switch (choice) {

						case 1:

							databaseService.viewStudentById(ID);

							break;

						case 2:

							databaseService.viewStudentById(ID);

							System.out.print("\n     Enter your Complaint about your data :- ");
							String s = scanner1.nextLine();

							databaseService.complaintStudent(new Student(ID, s));

							break;

						case 3:

							b = false;
							isStop = false;
							System.exit(0);

							break;

						default:

							System.out.println("\n......Invalid choice.....");

							break;
						}
					}
				} else {

					System.out.println("\n......Invalid Name.....");
				}
			}
		} catch (Exception e) {

			throw new RuntimeException("\n ...Something went wrong... " + e);
			// e.printStackTrace();
		}

	}
}

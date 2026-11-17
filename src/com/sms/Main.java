package com.sms;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sms.model.Student;

/**
 * Main class of the Student Management System. Handles the main menu and
 * student operations.
 */
public class Main {

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Student> students = new ArrayList<>();

	private static final int MIN_AGE = 8;

	/**
	 * Application entry point.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {

		showMainMenu();
	}

	/**
	 * Displays the main menu and handles user choices until the user selects the
	 * exit option.
	 */
	private static void showMainMenu() {
		int option;
		do {
			showMenu();
			try {
				option = scanner.nextInt();
				scanner.nextLine();

				switch (option) {
				case 1:
					addStudent();
					break;
				case 0:
					System.out.println("\nThank you for using our system!");
					break;
				default:
					System.out.println("\nInvalid option. Please try again");
				}
			} catch (InputMismatchException e) {
				scanner.nextLine();
				option = -1;
				System.out.println("Please enter a valid number");
			}
		} while (option != 0);
	}

	/**
	 * Displays the available student management options.
	 */
	private static void showMenu() {
		System.out.println("\n======================================");
		System.out.println("       STUDENT MANAGEMENT SYSTEM");
		System.out.println("======================================");
		System.out.println("Welcome! Manage your student records");
		System.out.println("\n1. Add New Student");
		System.out.println("0. Exit");
		System.out.print("\nEnter your choice: ");
	}

	/**
	 * Collects and validates student information, then adds the new student to the
	 * system.
	 */
	private static void addStudent() {
		String nationalId = getValidNationalId();

		while (findStudentByNationalId(nationalId) != null) {
			System.out.println("This National ID already exists!");
			nationalId = getValidNationalId();
		}

		System.out.println("Enter student name:");

		String name = scanner.nextLine();

		while (name.trim().isEmpty()) {
			System.out.println("Name cannot be empty\nTry again:");
			name = scanner.nextLine();
		}

		System.out.println("Enter student age:");
		while (!scanner.hasNextInt()) {
			System.out.println("Please enter a valid integer:");
			scanner.nextLine();
		}
		int age = scanner.nextInt();
		scanner.nextLine();

		while (age <= MIN_AGE) {
			System.out.println("Age must be greater than zero\nTry again:");
			while (!scanner.hasNextInt()) {
				System.out.println("Please enter a valid integer:");
				scanner.nextLine();
			}
			age = scanner.nextInt();
			scanner.nextLine();
		}

		System.out.println("Enter student grade:");
		while (!scanner.hasNextDouble()) {
			System.out.println("Please enter a valid number:");
			scanner.nextLine();
		}
		double grade = scanner.nextDouble();
		scanner.nextLine();

		while (grade < 0 || grade > 100) {
			System.out.println("Grade must be between 0 and 100 \nTry again:");
			while (!scanner.hasNextDouble()) {
				System.out.println("Please enter a valid number:");
				scanner.nextLine();
			}
			grade = scanner.nextDouble();
			scanner.nextLine();
		}

		students.add(new Student(nationalId, name, age, grade));
		System.out.println("Student added successfully!");
	}

	/**
	 * Searches for a student using their National ID.
	 *
	 * @param id the student's National ID
	 * @return the matching Student object, or null if not found
	 */
	private static Student findStudentByNationalId(String id) {
		for (Student student : students) {
			if (student.getNationalId().equals(id)) {
				return student;
			}
		}
		return null;
	}

	/**
	 * Reads and validates the student's National ID.
	 *
	 * @return a valid National ID
	 */
	private static String getValidNationalId() {
		System.out.print("Enter National ID: ");
		String nationalId = scanner.nextLine();

		while (!nationalId.matches("[12][0-9]{9}")) {
			System.out.println("Invalid National ID!");

			if (nationalId.trim().isEmpty()) {
				System.out.println("National ID cannot be empty");
			} else if (nationalId.length() != 10) {
				System.out.println("National ID must contain exactly 10 digits");
			} else if (!nationalId.matches("[12].*")) {
				System.out.println("National ID must start with 1 or 2");
			} else {
				System.out.println("National ID must contain digits only");
			}

			System.out.print("Enter National ID again: ");
			nationalId = scanner.nextLine();
		}

		return nationalId;
	}

}

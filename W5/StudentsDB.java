package com.itu.assignments;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentsDB {

	private LinkedList<String[]> studentRecords = new LinkedList<String[]>();
	
	public static void main(String[] args) {
		
		StudentsDB db = new StudentsDB();
		
		System.out.println("Welcome to the database menu!");
		System.out.println("-----------------------------");
		System.out.println("Press 1 to insert a new record");
		System.out.println("Press 2 to delete a record");
		System.out.println("Press 3 to search the database (by last name)");
		System.out.println("Press 4 to print a range in the database");
		System.out.println("Press 5 to find the class average for a course");
		System.out.println("Press 9 to quit");

		Scanner scanner = new Scanner(System.in);
		while(true){

			String option = scanner.nextLine();
			System.out.println(option);

			switch(option){
				case "1":  {
	
					System.out.println("Enter student record to insert:");
					System.out.println("Ex: FirstName LastName CourseCode Grade(number):");
					String record = scanner.nextLine();
					StringTokenizer stringTokenizer = new StringTokenizer(record);
					String[] student = new String[4];
	
					student[0] = (String)stringTokenizer.nextElement();
					student[1] = (String)stringTokenizer.nextElement();
					student[2] = (String)stringTokenizer.nextElement();
					student[3] = (String)stringTokenizer.nextElement();				
	
					db.insertRecord(student);
					break;
				}

				case "2":  {
					System.out.println("Enter student record to delete:");
					String record = scanner.nextLine();
					StringTokenizer stringTokenizer = new StringTokenizer(record);
					String[] student = new String[4];
	
					student[0] = (String)stringTokenizer.nextElement();
					student[1] = (String)stringTokenizer.nextElement();
					student[2] = (String)stringTokenizer.nextElement();
					student[3] = (String)stringTokenizer.nextElement();				
	
					db.deleteRecord(student);
					break;
	
				}

				case "3":  {
					System.out.println("Enter student record to search(by last name):");
					String lastName = scanner.nextLine();
					db.searchRecord(lastName);
					break;
	
				}

				case "4":  {
					System.out.println("Printing all records:");
					db.printDB();
					break;
	
				}

				case "5":  {
					System.out.println("Enter course to find class average: ");
					String courseName = scanner.nextLine();
					db.classAverage(courseName);
					break;
	
				}
			
				case "9":  {
					System.out.print("Existing program ..... ");
					scanner.close();
					System.exit(0);
				}
			}
		}
	}

	public void insertRecord(String[] record){
		studentRecords.addFirst(record);
	}

	public void deleteRecord(String[] record){
		studentRecords.remove(record);
	}

	public void searchRecord(String lastName){
		Iterator<String[]> itr = studentRecords.listIterator();
		while(itr.hasNext()){
			String[] record = (String[])itr.next();
			if(record[1].equals(lastName)){
				System.out.println("Student record search result: " 
						+ record[0] + " " + record[1] + " " + record[2] + " " + record[3]);
			}
		}
	}

	public void printDB(){
		Iterator<String[]> itr = studentRecords.listIterator();
		int i = 0;
		while(itr.hasNext()){
			String[] record = (String[])itr.next();
			System.out.println("Record  " + i + "--- "
					+ "FirstName:" + record[0] + " " 
					+ "LastName:" + record[1] + " " 
					+ "CourseCode:" + record[2] + " " 
					+ "Grade(int):" + record[3]);
			i++;	
		}

	}
	public void classAverage(String course){
		Iterator<String[]> itr = studentRecords.listIterator();
		int count = 0;
		int sum = 0;
		while(itr.hasNext()){
			String[] record = (String[])itr.next();
			if(record[2].equals(course)){
				sum = sum + Integer.valueOf(record[3]);
				count ++;
			}
		}
		System.out.println("Average of class for course " + course + " is :" + (int) sum/count);
	}
}

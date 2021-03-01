/***************************************************************
 * Name : StartProgram.java
 * Author: Devin Baack 
 * Created : 02/11/2021 
 * Course: CIS 175 - Java II
 * Version: 10.15.7 
 * OS: macOS Catalina 
 * IDE: Eclipse 2020-06
 * Copyright : This is my own original work based on specifications 
 * issued by our instructor 
 * Description : This program executes all of the implemented code in 
 * 				 ZooAnimal and ZooAnimalHelper.
 * Academic Honesty: I attest that this is my original work. I have
 * not used unauthorized source code, either modified or unmodified. 
 * I have not given other fellow student(s) access to my program.
 ***************************************************************
 */
 
package controller;

import java.util.List;
import java.util.Scanner;

import model.ZooAnimal;
import controller.ZooAnimalHelper;

/**
 * @author Devin Baack - dfbaack
 * CIS175 - Spring 2021
 * Feb 11, 2021
 */
public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static ZooAnimalHelper zah = new ZooAnimalHelper();

	private static void addAnAnimal() {
		// TODO Auto-generated method stub
		System.out.print("Enter an animal: ");
		String animal = in.nextLine();
		System.out.print("Enter a gender: ");
		String gender = in.nextLine();
		System.out.print("Enter an age: ");
		int age = in.nextInt();
		ZooAnimal toAdd = new ZooAnimal(animal, gender, age);
		zah.insertAnimal(toAdd);

	}

	private static void deleteAnAnimal() {
		// TODO Auto-generated method stub
		System.out.print("Enter the ID of the animal to delete: ");
		int id = in.nextInt();
		
		ZooAnimal toDelete = zah.searchForAnimalById(id);
		zah.deleteAnimal(toDelete);

	}

	private static void editAnAnimal() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Animal");
		System.out.println("2 : Search by Gender");
		System.out.println("3 : Search by Age");
		int searchBy = in.nextInt();
		in.nextLine();
		
		List<ZooAnimal> foundAnimals;
		if (searchBy == 1) {
			System.out.print("Enter the animal name: ");
			String animal = in.nextLine();
			foundAnimals = zah.searchForAnimalByAnimal(animal);
			
		} else if(searchBy == 2){
			System.out.print("Enter the gender: ");
			String gender = in.nextLine();
			foundAnimals = zah.searchForAnimalByGender(gender);
			

		}else {
			System.out.print("Enter the age: ");
			int age = in.nextInt();
			foundAnimals = zah.searchForAnimalByAge(age);
			
		}

		if (!foundAnimals.isEmpty()) {
			System.out.println("Found Results.");
			for (ZooAnimal z : foundAnimals) {
				System.out.println(z.getId() + " : " + z.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ZooAnimal toEdit = zah.searchForAnimalById(idToEdit);
			System.out.println("Retrieved " + toEdit.getAnimal());
			System.out.println("1 : Update Animal");
			System.out.println("2 : Update Gender");
			System.out.println("3 : Update Age");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Animal: ");
				String newAnimal = in.nextLine();
				toEdit.setAnimal(newAnimal);
			} else if (update == 2) {
				System.out.print("New Gender: ");
				String newGender = in.nextLine();
				toEdit.setGender(newGender);
			}else if (update == 3) {
				System.out.print("New Age: ");
				int newAge = in.nextInt();
				toEdit.setAge(newAge);
			}

			zah.updateAnimal(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our Zoo Animal List! ---");
		while (goAgain) {
			System.out.println("*  Select an Animal:");
			System.out.println("*  1 -- Add an Animal");
			System.out.println("*  2 -- Edit an Animal");
			System.out.println("*  3 -- Delete an Animal");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnAnimal();
			} else if (selection == 2) {
				editAnAnimal();
			} else if (selection == 3) {
				deleteAnAnimal();
			} else if (selection == 4) {
				viewTheList();
			} else {
				zah.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<ZooAnimal> zooAnimals = zah.showAllAnimals();
		for(ZooAnimal zooAnimal : zooAnimals ) {
			System.out.println(zooAnimal.returnAnimalDetails());
		}

	}

}

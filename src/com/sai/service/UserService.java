package com.sai.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sai.model.UserDetails;

public class UserService {
	private List<UserDetails> users;
	private Map<String, Integer> invaliadLoginAttempts;

	public UserService(List<UserDetails> users, Map<String, Integer> invaliadLoginAttempts) {
		this.users = users;
		this.invaliadLoginAttempts = invaliadLoginAttempts;
	}

	public void registernewAdminUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your first name");
		String firstName = scanner.nextLine();
		System.out.println("Please enter your last name");
		String lastName = scanner.nextLine();
		System.out.println("Please enter your mobile numbur");
		String mobileNumber = scanner.nextLine();
		System.out.println("Please enter your gender");
		String gender = scanner.nextLine();
		System.out.println("Please enter your email Id");
		String emailId = scanner.nextLine();
		System.out.println("Please enter yoour password");
		String password = scanner.nextLine();
		
		if(isvalidEmail(emailId)) {
			System.out.println("This emailId Already exist \n please enter another email Id");
			return;
		}
		
		UserDetails newUserDetails=new UserDetails(firstName, lastName, mobileNumber, gender, emailId, password, 0, "active");
		users.add(newUserDetails);
		System.out.println("User registeration successfull");
	}

	private boolean isvalidEmail(String emailId) {
		for (UserDetails userDetails : users) {
			if (userDetails.getEmail_id().equals(emailId)) {
				return true;
			}

		}
		return false;

	}
	
	public UserDetails logIn() {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please login");
		System.out.println("Please enter your emailId");
		String emailId=scanner.nextLine();
		System.out.println("Please enter your password");
		String password=scanner.nextLine();
		
		for (UserDetails userDetails : users) {
			
			if(userDetails.getEmail_id().equals(emailId)) {
				Integer existingFaildCount= invaliadLoginAttempts.getOrDefault(emailId, 0);
				if(existingFaildCount>=5) {
					System.out.println("Your Account is Locked");
					return null;
				}
				if(userDetails.getPassword().equals(password)) {
					System.out.println("Your login Successfull");
					invaliadLoginAttempts.put(emailId, 0);
					return userDetails;
				}
				else {
					invaliadLoginAttempts.put(emailId, existingFaildCount+1);
					System.out.println("Your login attempet faild count is "+existingFaildCount);
				}
			}
			
		}
		System.out.println("No User Found with this eamil "+emailId);
		
		return null;
		
	}

}

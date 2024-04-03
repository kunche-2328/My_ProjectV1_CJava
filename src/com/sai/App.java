package com.sai;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sai.model.Booking;
import com.sai.model.Route;
import com.sai.model.UserDetails;
import com.sai.service.JourneyService;
import com.sai.service.UserService;

public class App {
	List<Route> routes=new ArrayList<>();
	List<Booking> booking=new ArrayList<>();
	List<UserDetails> userDetails=new ArrayList<>();
	Map<String, Integer> invalidAttempts=new HashMap();
	JourneyService journeyService=new JourneyService(routes, booking);
	UserService userService=new UserService(userDetails, invalidAttempts);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app=new App();
		app.initializeRoutes();
		app.showMenu();

	}
	
	private  void initializeRoutes() {
        routes.add(new Route(1, "Nellore", "Hyderabad", LocalDate.parse("2024-01-20", DateTimeFormatter.ISO_LOCAL_DATE), 1000, 40));
        routes.add(new Route(2, "Hyderabad", "Goa", LocalDate.parse("2024-01-19", DateTimeFormatter.ISO_LOCAL_DATE), 1500, 40));
        // ... add more routes as needed
    }
	
	private void showMenu() {
		Scanner scanner=new Scanner(System.in);
		int choice;
		boolean running=true;
		
		while(running) {
			System.out.println("\n Menu");
			System.out.println("Registr newAdmin User press 1");
			System.out.println("Login press 2");
			System.out.println("Plan a Journey press 3");
			System.out.println("Press 3 for Exit");
			System.out.println("Please Enter your choice");

			choice = Integer.parseInt(scanner.nextLine());
			
			switch(choice) {
			case 1:
				userService.registernewAdminUser();
				break;
			case 2:
				userService.logIn();
				break;
			case 3:
				journeyService.planJourney();
				break;
			case 4:
				System.out.println("Session Completedd 'EXIT' ");
				running=false;
				break;
			default :
				System.out.println("Invalid choice Try again later");
			
			}
		}
		
	}

}

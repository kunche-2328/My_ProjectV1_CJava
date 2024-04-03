package com.sai.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sai.model.Booking;
import com.sai.model.Journey;
import com.sai.model.Route;

public class JourneyService {
	private List<Route> routes;
	private List<Booking> bookings;

	public JourneyService(List<Route> routes, List<Booking> booking) {
		this.routes = routes;
		this.bookings = booking;
	}

	public void planJourney() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n Plan Journey");

		System.out.println("Enter From location");
		String from = scanner.nextLine();
		System.out.println("Enter To location");
		String to = scanner.nextLine();
		System.out.println("Enter Data of Journey (YYYY-MM-DD)");
		String dateOfJourney = scanner.nextLine();
		LocalDate journeyDate = LocalDate.parse(dateOfJourney, DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println("Enter No of Passengers");
		int noOfPassengers = scanner.nextInt();

		List<Route> matchingRoutes = gerRoutes(from, to, journeyDate, noOfPassengers);
		if(!matchingRoutes.isEmpty()) {
			System.out.println("Available Routes");
			for(int i=0; i<matchingRoutes.size(); i++) {
				System.out.println((i+1)+": "+matchingRoutes.get(i));
			}
			System.out.println("Select a Route Number");
			int routeNumber=scanner.nextInt();
			Route selectedRoute = matchingRoutes.get(routeNumber-1);
			Booking newBooking=createOrder(journeyDate, noOfPassengers, selectedRoute);
			bookings.add(newBooking);
			System.out.println("Journey Planned successfull. Order Details: "+newBooking);
			}
		else {
			System.out.println("No availble routes found for the given details");
		}

	}

	private List<Route> gerRoutes(String from, String to, LocalDate date, int numberofPassengers) {
		List<Route> matchingRoutes = new ArrayList<>();
		for (Route route : this.routes) {
			if (route.getSource().equals(from) && route.getDestination().equals(to)
					&& route.getJourneyDate().equals(date) && route.getNoOfSeatsAvailable() >= numberofPassengers) {
				matchingRoutes.add(route);
			}

		}
		return matchingRoutes;
	}
	private Booking createOrder(LocalDate date, int passengers, Route selectedRoute) {
		Booking newBooking=new Booking();
		double bookingcost=selectedRoute.getTicketPricePerPassenger()*passengers;
		if(date.getDayOfWeek()==DayOfWeek.SATURDAY || date.getDayOfWeek()==DayOfWeek.SUNDAY) {
			bookingcost=bookingcost+200; // Weekends charges
			bookingcost=bookingcost*0.1; //Adding 10% GST
		}
		newBooking.setOrderAmount(bookingcost);
		newBooking.setRoute(selectedRoute);
		newBooking.setRequestedJourneyPlan(new Journey(date, passengers));
		newBooking.setOrderStatus("Created");
		newBooking.setOrderId(bookings.size()+1);
		
		return newBooking;
		
	}

}

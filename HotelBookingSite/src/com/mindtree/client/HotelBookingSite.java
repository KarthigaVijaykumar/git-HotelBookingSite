package com.mindtree.client;

import java.util.List;
import java.util.Scanner;

import com.mindtree.entity.Hotel;
import com.mindtree.entity.Room;
import com.mindtree.exception.ServiceException.HotelServiceException;
import com.mindtree.service.HotelService;
import com.mindtree.service.Impl.HotelServiceImpl;


public class HotelBookingSite {
	private static Scanner input = new Scanner(System.in);
	private static HotelService hotelservice = new HotelServiceImpl();
	public static void main(String[] args) {
		boolean valid = true;
		do {
			System.out.println("1.Insert hotels\n2.Insert rooms\n3.Display hotel based on city\nEnter your choice");
			byte choice = input.nextByte();
			switch(choice) {
			case 1:
				Hotel hotel =addHotelDetails();
				boolean isInserted = false;
				try {
					isInserted = hotelservice.insertHotelToDB(hotel);
				} catch (HotelServiceException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(isInserted) {
					System.out.println("Hotel got inserted succesfully");
				}
				break;
			case 2:
				Room room = addRoomDetails();
				boolean inserted = false;
				try {
					inserted = hotelservice.insertRoomToDB(room);
				} catch(HotelServiceException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(inserted) {
					System.out.println("Room got inserted successfully");
				}
				break;
			case 3:
				System.out.println("Enter the city to display the list of hotels available");
				String city = input.next();
				try {
					List<Hotel> list = hotelservice.getHotelsFromDB(city);
					displayHotelsInCityFromDB(list);
				} catch (HotelServiceException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("The Application is exited");
				valid = false;
				break;
			}
		}
		while(valid);
	}
	public static void displayHotelsInCityFromDB(List<Hotel> hotels) {
		if(hotels != null) {
			for(Hotel hotel : hotels) {
				System.out.println(hotel.getHotelId()+" "+hotel.getHotelName()+" "+hotel.getHotelCity());
			}
		}
		
	}
	private static Hotel addHotelDetails(){
		System.out.println("Enter hotel id");
		int hotelId = input.nextInt();
		System.out.println("Enter hotel name");
		String hotelName = input.next();
		System.out.println("Enter hotel city");
		String hotelCity = input.next();
		Hotel hotel = new Hotel(hotelId,hotelName,hotelCity);
		return hotel;
	}
	private static Room addRoomDetails() {
		System.out.println("Enter the room number");
		int roomNo = input.nextInt();
		System.out.println("Enter the room type (luxury/semiluxury/deluxe)");
		String roomType = input.next();
		System.out.println("Enter the room cost");
		float roomCost = input.nextFloat();
		Hotel hotel = addHotelDetails();
		Room room = new Room(hotel,roomNo,roomType,roomCost);
		return room;
	}
}

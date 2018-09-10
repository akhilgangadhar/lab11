package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import exception.MobileException;
import exception.PurchaseException;
import service.IMobileService;
import service.IPurchaseService;
import service.MobileService;
import service.PurchaseService;
import bean.Mobile;
import bean.PurchaseDetails;

public class MobileMain {
	
	static IMobileService ser = null;
	
	static Mobile populateMobile(){
		Mobile mob = new Mobile();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter mobile id");
		mob.setId(sc.nextInt());
		System.out.println("Enter mobile name");
		mob.setName(sc.next());
		System.out.println("Enter mobile price");
		mob.setPrice(sc.nextDouble());
		System.out.println("Enter mobile quantity");
		mob.setQuantity(sc.nextInt());
		sc.close();
		return mob;
	}
	
	static PurchaseDetails populatePurchaseDetails(){
		PurchaseDetails pur = new PurchaseDetails();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ur name");
		pur.setCname(sc.nextLine());
		System.out.println("Enter ur mail id");
		pur.setMailId(sc.nextLine());
		System.out.println("Enter ur phone number");
		pur.setPhno(sc.nextLine());
		System.out.println("Enter the mobile id of the mobile u want to purchase");
		pur.setPurchaseDate(LocalDate.parse(sc.nextLine()));
		return pur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice,option;
		Double lprice,hprice;
		
		Mobile mob = null;
		PurchaseDetails pur = null;
		List<Mobile> list  = null;
		IPurchaseService pser = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER 1 FOR ADMIN AND 2 FOR CUSTOMER");
		choice = sc.nextInt();
		if(choice == 1){
			System.out.println("   WELCOME ADMIN   ");
			System.out.println("\n");
			
			try{
				while(true){
				
					System.out.println("1.Add Mobile ");
					System.out.println("2.Delete Mobile");
					System.out.println("3.Retrive All");
					System.out.println("4.Exit");
					System.out.println("________________________________");
					System.out.println("Select an option:");
					
					option = sc.nextInt();
					sc.nextLine();
				
					switch(option){
						
					case 1:
							if(mob == null){
								mob = populateMobile();
								ser = new MobileService();
								try {
									ser.addMobileDetails(mob);
								} catch (MobileException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("Mobile added successfully");
							}
						break;
					case 2:
							System.out.println("Enter the id of mobile u want to delete");
							String id = sc.nextLine();
							ser = new MobileService();
						try {
							ser.deleteMobileDetails(id);
						} catch (MobileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							System.out.println("Mobile deleted successfully");
							break;
					case 3:
							ser = new MobileService();
							list = new ArrayList<Mobile>();
						try {
							list = ser.retriveAllDetails();
						} catch (MobileException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							if(list != null){
								Iterator<Mobile> itr = list.iterator();
								while(itr.hasNext()){
									System.out.println(itr.next());
								}
							}
						break;
					case 4:
						System.out.println("Exiting application");
						System.exit(0);
						break;
					default:
						System.out.println("Enter a valid option[1-4]");
					}
				}
			}catch(InputMismatchException e){
				e.printStackTrace();
			}
		}else if(choice == 2){
			System.out.println("   WELCOME CUSTOMER   ");
			System.out.println("\n");
			try{
			while(true){
				
				System.out.println("1.VIEW ALL MOBILES");
				System.out.println("2.SEARCH IN A PRICE RANGE");
				System.out.println("3.Buy a phone");
				System.out.println("4.Exit");
				System.out.println("________________________________");
				System.out.println("Select an option:");
				
				option = sc.nextInt();
			
				switch(option){
				case 1:
					ser = new MobileService();
					list = new ArrayList<Mobile>();
					try {
						list = ser.retriveAllDetails();
					} catch (MobileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(list != null){
						Iterator<Mobile> itr = list.iterator();
						while(itr.hasNext()){
							System.out.println(itr.next());
						}
					}
					break;
				case 2:
					ser = new MobileService();
					list = new ArrayList<Mobile>();
					System.out.println("Enter lower price");
					lprice = sc.nextDouble();
					System.out.println("Enter higher price");
					hprice = sc.nextDouble();
					try {
						list = ser.searchRange(lprice,hprice);
					} catch (MobileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(list != null){
						Iterator<Mobile> itr = list.iterator();
						while(itr.hasNext()){
							System.out.println(itr.next());
						}
					}
					break;
				case 3:
					pur = populatePurchaseDetails();
					pser = new PurchaseService();
					try {
						pser.validateDetails(pur);
						pser.addPurchaseDetails(pur);
					} catch (PurchaseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				case 4:
					System.out.println("Exiting application");
					System.exit(0);
					break;
				}
			}
			}catch(InputMismatchException e){
				
			}
		}
	}
}

package hotel;

import java.util.Scanner;

public class Solution
{

	public static void main(String[] args) {
		System.out.println("Welcome To XYZ Hotel\n---------------------");

		Scanner sc = new Scanner(System.in);
		HotelManagementSysem hotel = new HotelManagementSystemImpl(); //upcasting

		hotel.addFood(); // Adding all food dishes into the database
		System.out.println("---------------------");
		int input = 1;


		while(input == 1)
		{
			System.out.println("1:Order food\n2:Checkout\nEnter your choice");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
			{
				hotel.displayFood();
				hotel.orderFood();
				break;
			}
			case 2:
			{
				hotel.checkOut();
				System.out.println("thank You!!!");
				System.exit(0);
			}
			default :
			{
				try
				{
					throw new InvalidChoiceException("Invalid choice,Please enter valid choice");
				}
				
				catch(InvalidChoiceException e)
				{
					System.out.println(e.getMessage());
				}
			}// end of switch

			System.out.println("Enter 1 to continue, Any Other Number to Exit");
			input = sc.nextInt();
			System.out.println("-------------------");
			}
		}//end of while
		hotel.checkOut();
		System.out.println("Thank You!!!");
	}

}

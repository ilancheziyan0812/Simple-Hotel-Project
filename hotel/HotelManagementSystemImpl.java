package hotel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelManagementSystemImpl implements  HotelManagementSysem{

	Scanner sc = new Scanner(System.in);
	Map<Integer,Food> map = new LinkedHashMap<Integer,Food>();
	private int totalCost;


	@Override
	public void addFood() {
		map.put(1,new Food(1,"ChickenBriyani",250,5));
		map.put(2,new Food(2,"kabab",150,5));
		map.put(3,new Food(3,"Fish briyani",350,3));
		map.put(4,new Food(4,"Mutton Briyani",450,7));
		map.put(5,new Food(5,"Mushroom Briyani",250,2));
		System.out.println("Food Menu Created");

	}

	@Override
	public void displayFood() {

		Set<Integer> keys =map.keySet();// 1 2 3 4 5
		// mistake generic next for inside int datatype because key is integer
		for(int key : keys)
		{
			System.out.println("Enter " + key+"--->"+map.get(key));
		}

	}

	@Override
	public void orderFood() {
		// 1. get the food object based on id/choice -->get()
		// 2.accept quantity ->set new quantity
		//3.calculate cost
		//4.cost --> total bill
		//5.InvalidQuantityException

		System.out.println("Enter food id");
		int id = sc.nextInt();

		Food food=  map.get(id);

		System.out.println("Ordering "+food.getName());
		//System.out.println("Ordering "+food.getCost());

		System.out.println("Enter Quantity");
		int quan =  sc.nextInt();


		if(quan <= food.getQuantity() )
		{

			//			food.setQuantity(quan);
			//
			//			int cost=food.getCost();
			//			int total = cost * quan;
			//
			//
			//			System.out.println("Total bill");
			//			System.out.println(total);

			food.setQuantity(food.getQuantity()-quan); // decrease quantity
			int currentCost = food.getCost()*quan;
			totalCost = totalCost + currentCost;
			System.out.println("Ordered "+quan+" "+food.getName()+" at the cost of Rs."+currentCost);



		}
		else
		{
			try
			{

				throw new InvalidChoiceException("Invalid choice,Please enter valid choice");
			}
			catch(InvalidChoiceException e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void checkOut() {

		if(totalCost != 0)
		{
			System.out.println("Total Bill : "+totalCost);
		}
		else
		{
			System.out.println("No food Selected");
		}

	}


}

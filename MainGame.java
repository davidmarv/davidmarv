package blackJack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainGame {

public static ArrayList<String> deck = new ArrayList<String>();
private static ArrayList<String> suits= new ArrayList<String>();
private static ArrayList<String> values= new ArrayList<String>();
public static ArrayList<String> playerHand = new ArrayList<String>();
public static int playerValue = 0;
public static ArrayList<String> dealerHand = new ArrayList<String>();
public static int dealerValue = 0;
	public static void main(String[] args) {
		

		 Deck();
		 
		 round();
		 checkWinner();

	}

	public static void Deck()
	{

		suits.add("Clubs");
		suits.add("Spaids");
		suits.add("Diamonds");
		suits.add("Hearts");
		

		values.add("Ace");
		values.add("Two");
		values.add("Three");
		values.add("Four");
		values.add("Five");
		values.add("Six");
		values.add("Seven");
		values.add("Eight");
		values.add("Nine");
		values.add("Ten");
		values.add("Jack");
		values.add("Queen");
		values.add("King");
		
		
		for (int i =0; i < suits.size(); i++)
		{
			for (int j =0; j < values.size(); j++)
			{
				deck.add(values.get(j)+ " Of " + suits.get(i));
			}
		}		
		
	}
	
	public static int getValue(String cards) 
	{
		if (cards.contains("Ace "))
		{
			return 11;
		}
		
		else if (cards.contains("Two "))
		{
			return 2;
		}
		else if (cards.contains("Three "))
		{
			return 3;
		}
		else if (cards.contains("Four "))
		{
			return 4;
		}
		else if (cards.contains("Five "))
		{
			return 5;
		}
		else if (cards.contains("Six "))
		{
			return 6;
		}
		else if (cards.contains("Seven "))
		{
			return 7;
		}
		else if (cards.contains("Eight "))
		{
			return 8;
		}
		else if (cards.contains("Nine "))
		{
			return 9;
		}
		else if (cards.contains("Ten "))
		{
			return 10;
		}
		else if (cards.contains("Jack "))
		{
			return 10;
		}
		else if (cards.contains("Queen "))
		{
			return 10;
		}
		else if (cards.contains("King "))
		{
			return 10;
		}
		
		else {return 99;}

	}
	
	public static String drawCard(){
		
		String randCard = "";
		
		Random rn = new Random();
		int rand = rn.nextInt(deck.size());
		
		randCard = deck.get(rand);
		deck.remove(rand);

		return randCard;
		
	}
	
	public static void DealerDraw()
	{
		dealerHand.add(drawCard());
		
		dealerValue =0;
		for (int i = 0; i < dealerHand.size(); i++)
		{
			dealerValue += getValue(dealerHand.get(i));
		}
	}
		
	public static void PlayerDraw()
	{

		playerHand.add(drawCard());
		
		playerValue = 0;
		for (int i = 0; i < playerHand.size(); i++)
		{
			playerValue += getValue(playerHand.get(i));
		}
	}
	
	public static void playerHit()
	{
		PlayerDraw();
		playerCheckBust();
		

	}
	public static void dealerHit()
	{
		DealerDraw();
		
		

	}
	
	public static String playerCheckBust()
	{
		if (playerValue >21) {
			return "Bust";
		}
		else {return"";}
	}
	
	public static String dealerCheckBust()
	{
		if (dealerValue >21) {
			return "Bust";
		}
		else {return"";}
	}

	
	public static void round()
	{
		DealerDraw();
		PlayerDraw();
		DealerDraw();
		PlayerDraw();
		System.out.print("Dealers visible hand: ");
		System.out.println(dealerHand.get(0));
		System.out.print("players Hand: ");
		System.out.println(playerHand);
		
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Would you like to hit");
	    String hit = myObj.nextLine();
	    
	    while (hit.equals("yes") && playerValue <=21)
	    {
	    	playerHit();
	    	System.out.print("players Hand: ");
	    	System.out.println(playerHand);
	    	if (playerCheckBust().equals("Bust"))
	    	{
	    		break;
	    	}
	    	System.out.print("players value: ");
	    	System.out.println(playerValue);
	    	System.out.println("Would you like to hit");
		    hit = myObj.nextLine();
	    }
	    System.out.println("player turn over");
	    
	    while (dealerValue <=16)
	    {
	    	System.out.print("dealers Hand: ");
	    	System.out.println(dealerHand);
	    	System.out.println("dealer hits");
	    	dealerHit();
	    	System.out.print("dealers Hand: ");
	    	System.out.println(dealerHand);
	    	System.out.println(dealerCheckBust());
	    	System.out.print("dealers value: ");
	    	System.out.println(dealerValue);
	    }
	    System.out.print("dealers Hand: ");
    	System.out.println(dealerHand);
	    
		
	}
	
	
	public static void checkWinner()
	{
		if (playerValue > 21)
		{
			System.out.println("dealer wins");
		}
		else if (dealerValue > 21)
		{
			System.out.println("Player wins");
		}
		else if (playerValue > 21)
		{
			System.out.println("dealer wins");
		}
		
		else if (playerValue > dealerValue)
		{
			System.out.println("player wins");
		}
		else
		{
			System.out.println("dealer wins");
		}
		
	}
}
	
	
	
	
	
	
	
	


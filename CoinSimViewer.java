//package programmingassignment;

import java.util.Scanner;

import javax.swing.JFrame;

/**
 * CoinSimViewer class
 * 
 * 
 * Contains the main method. Prompts for the number of trials, and 
 * Creates the JFrame containing the CoinSimComponent. 
 * Prompts for the number of trials, you will error check that a positive value is entered.
 * And print out a informative error message and then prompt and read again until the 
 * user enters a valid value.
 * 
 */


public class CoinSimViewer 
{

	public static void main(String[] args) 
	{

		JFrame frame = new JFrame();

		//Creates the JFrame containing the CoinSimComponent

		frame.setSize(800, 500);
		frame.setTitle("CoinSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CoinSimComponent component =new CoinSimComponent();
		frame.add(component);

		// Input from user and checks whether it is valid or not.

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of trials");
		int numTrials = input.nextInt();

		CoinTossSimulator toss = new CoinTossSimulator();
		toss.setNumTrials(numTrials);

		if(numTrials>0)
		{
			frame.setVisible(true);
		}
		else if(numTrials<=0)
		{
			while(numTrials<=0)
			{
				System.out.println("Error: Number entered must be greater than zero");
				System.out.println("Enter the number of trials");
				int numTrials1 = input.nextInt();
				if(numTrials1>0)
				{
					frame.setVisible(true);
					break;
				}

			}

		}
	}
}

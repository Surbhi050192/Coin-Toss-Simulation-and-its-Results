//package programmingassignment;

import java.util.Scanner;

/**
 * CoinTossSimulatorTester class
 * 
 * Contains the main method having fixed input values to test the functionlity 
 * of CoinTossSimulator using Random Generator input.
 * 
 */

public class CoinTossSimulatorTester 
{
	private final static void Tester(int numTrial, int Heads, int Tail, int HeadTails )
	{
		boolean b = false;

		System.out.println("Number of trials: " + numTrial);
		System.out.println("Two-head tosses: " + Heads);
		System.out.println("Two-tail tosses: "+ Tail);
		System.out.println("One-head one-tail tosses: " + HeadTails);
		int s =  Heads + Tail + HeadTails;
		if(s == numTrial)
			b = true;
		System.out.println("Tosses add up correctly? " + b);
		System.out.println();

	}

	public static void main(String[] args)
	{
		CoinTossSimulator toss = new CoinTossSimulator();


		System.out.println("After Constructor: ");
		Tester(toss.getNumTrials(), toss.getTwoHeads(), toss.getTwoTails(), toss.getHeadTails());

		toss.run(0);
		System.out.println("After run:("+toss.getNumTrials() +")");
		Tester(toss.getNumTrials(), toss.getTwoHeads(), toss.getTwoTails(), toss.getHeadTails());

		toss.reset();
		toss.run(1);
		System.out.println("After run:("+toss.getNumTrials() +")");
		Tester(toss.getNumTrials(), toss.getTwoHeads(), toss.getTwoTails(), toss.getHeadTails());

		toss.reset();
		toss.run(10);
		System.out.println("After run:("+toss.getNumTrials() +")");
		Tester(toss.getNumTrials(), toss.getTwoHeads(), toss.getTwoTails(), toss.getHeadTails());

		toss.reset();
		toss.run(100);
		System.out.println("After run:("+toss.getNumTrials() +")");
		Tester(toss.getNumTrials(), toss.getTwoHeads(), toss.getTwoTails(), toss.getHeadTails());


		toss.reset();
		System.out.println("After reset: ");
		Tester(toss.getNumTrials(), toss.getTwoHeads(), toss.getTwoTails(), toss.getHeadTails());


		toss.run(1100);
		System.out.println("After run:("+toss.getNumTrials() +")");
		Tester(toss.getNumTrials(), toss.getTwoHeads(), toss.getTwoTails(), toss.getHeadTails());



	}
}






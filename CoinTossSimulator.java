//package programmingassignment;

import java.util.Random;
import java.util.Scanner;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator 
{

	private int TwoHeads;
	private int HeadsAndTail;
	private int TwoTails;
	private static int numTrial;
	private int firstCoinToss;
	private int secondCoinToss;


	Random generator = new Random(25323);

	/**
      Creates a coin toss simulator with no trials done yet.
	 */
	public CoinTossSimulator()
	{

		firstCoinToss = 0;
		secondCoinToss = 0;
		TwoHeads = 0;
		HeadsAndTail = 0;
		TwoTails = 0;

	}


	/**
      Runs the simulation for numTrials more trials. Multiple calls to this
      without a reset() between them add these trials to the simulation
      already completed.

      @param numTrials  number of trials to for simulation; must be >= 0
	 */
	public void run(int numTrials) 
	{
		numTrial = numTrials;


		for(int i=1; i<=numTrial; i++)
		{
			//Simulation using a random-number generator

			firstCoinToss = generator.nextInt(2);
			secondCoinToss = generator.nextInt(2);

			if(firstCoinToss == 1 && secondCoinToss == 1)
			{
				TwoHeads = TwoHeads + 1;

			}
			if((firstCoinToss == 1 && secondCoinToss == 0) || 
					(firstCoinToss == 0 && secondCoinToss == 1))
			{
				HeadsAndTail = HeadsAndTail + 1;
			}
			if(firstCoinToss == 0 && secondCoinToss == 0)
			{
				TwoTails = TwoTails + 1;
			}


		}



	}


	/**
      Get number of trials performed since last reset.
	 */
	public int getNumTrials() 
	{	

		return numTrial; // DUMMY CODE TO GET IT TO COMPILE

	}
	public void setNumTrials(int numTrial) 
	{	

		CoinTossSimulator.numTrial = numTrial; // DUMMY CODE TO GET IT TO COMPILE

	}


	/**
      Get number of trials that came up two heads since last reset.
	 */
	public int getTwoHeads() 
	{

		return TwoHeads; // DUMMY CODE TO GET IT TO COMPILE
	}


	/**
     Get number of trials that came up two tails since last reset.
	 */  
	public int getTwoTails() 
	{

		return TwoTails; // DUMMY CODE TO GET IT TO COMPILE
	}


	/**
     Get number of trials that came up one head and one tail since last reset.
	 */
	public int getHeadTails() 
	{
		return HeadsAndTail; // DUMMY CODE TO GET IT TO COMPILE
	}


	/**
      Resets the simulation, so that subsequent runs start from 0 trials done.
	 */
	public void reset() 
	{

		TwoHeads = 0;
		HeadsAndTail = 0;
		TwoTails = 0;
		numTrial = 0;
	}





}

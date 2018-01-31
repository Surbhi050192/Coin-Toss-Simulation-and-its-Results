//package programmingassignment;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * CoinSimComponent class
 * 
 * 
 * Extends JComponent. Constructor initializes percentage of tosses. 
 * Overrides paintComponent to draw the bar graph, using Bar objects for each bar in the graph. 
 * This class is using the CoinTossSimulator and Bar class.
 * 
 */

public class CoinSimComponent extends JComponent
{

	private int percentOfHeads;
	private int percentOfTails;
	private int percentOfHeadsAndTails;
	private static CoinTossSimulator toss;


	public CoinSimComponent()
	{

		percentOfHeads = 0;
		percentOfTails = 0;
		percentOfHeadsAndTails = 0;

	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		if(toss == null)
		{
			toss = new CoinTossSimulator();
			toss.run(toss.getNumTrials());
		}

		//Calculation of probability of tosses of coins.

		percentOfHeads = ((toss.getTwoHeads()*100)/toss.getNumTrials());
		percentOfTails = ((toss.getTwoTails()*100)/toss.getNumTrials());
		percentOfHeadsAndTails = ((toss.getHeadTails()*100)/toss.getNumTrials());

		//Label Syntax

		String label1 = "Two Heads: " + toss.getTwoHeads() + " "  + "(" + percentOfHeads + "%)";
		String label2 = "A Head and A Tail: " + toss.getHeadTails() + " " + "(" + percentOfHeadsAndTails + "%)";
		String label3 = "Two Tails: " + toss.getTwoTails() + " "  + "(" + percentOfTails + "%)";



		Font font = g2.getFont();
		FontRenderContext context = g2.getFontRenderContext();

		Rectangle2D labelBounds1 = font.getStringBounds(label1, context);
		int widthOfLabel1 = (int) labelBounds1.getWidth(); //To get the width of Label
		int heightOfLabel1 = (int) labelBounds1.getHeight(); //To get the height of Label


		Rectangle2D labelBounds2 = font.getStringBounds(label2, context);
		int widthOfLabel2 = (int) labelBounds2.getWidth();
		int heightOfLabel2 = (int) labelBounds2.getHeight();

		Rectangle2D labelBounds3 = font.getStringBounds(label3, context);
		int widthOfLabel3 = (int) labelBounds3.getWidth();
		int heightOfLabel3 = (int) labelBounds3.getHeight();


		//Color of the bar

		Color colorbar1 = new Color(255, 0, 0);
		Color colorbar2 = new Color(0, 255, 0);
		Color colorbar3 = new Color(0, 0, 255);



		int widthofComponent = getWidth(); //To get the width and height of Component
		int heightofComponent = getHeight();


		int widthOfBar = 40; //To get the width of bar

		int Left2 = widthofComponent/2 - widthOfBar/2; //To get the left position or x coordinate of Bar
		int Left1 = Left2/2 - widthOfBar/2;
		int Left3 = ((widthofComponent/2 + widthOfBar/2) + widthofComponent)/2 - widthOfBar/2;


		double unitsPerPixel1 =  heightofComponent/110;
		double unitsPerPixel2 =  heightofComponent/110;
		double unitsPerPixel3 =  heightofComponent/110;


		int numUnits1 = percentOfHeads * ((int)unitsPerPixel1); //To get the height of Bar
		int numUnits2 = percentOfHeadsAndTails * ((int)unitsPerPixel2);
		int numUnits3 = percentOfTails * ((int)unitsPerPixel3);


		//Calculation of y coordinate

		int bottom1 = (heightofComponent-40) - numUnits1; 
		int bottom2 = (heightofComponent-40) - numUnits2;
		int bottom3 = (heightofComponent-40) - numUnits3;

		//Creation of bar object

		Bar bar1 = new Bar(Left1, bottom1, widthOfBar, numUnits1,
				unitsPerPixel1,  colorbar1,  label1);
		Bar bar2 = new Bar(Left2,bottom2, widthOfBar, numUnits2,
				unitsPerPixel2,  colorbar2,  label2);
		Bar bar3 = new Bar(Left3,bottom3, widthOfBar, numUnits3,
				unitsPerPixel3,  colorbar3,  label3);


		//Creation of bar with filled color and label through draw() method in Bar class

		if(percentOfHeads>0)
		{
			g2.setColor(colorbar1);
			bar1.draw(g2);
			g2.drawString(label1, (Left1 - (widthOfLabel1/2)) + (widthOfBar/2), heightofComponent-heightOfLabel1 );
			g2.fillRect(Left1, bottom1 , widthOfBar, numUnits1);
		}



		if(percentOfHeadsAndTails>0)
		{
			g2.setColor(colorbar2);
			bar2.draw(g2);
			g2.drawString(label2, (Left2 - (widthOfLabel2/2)) + (widthOfBar/2), heightofComponent-heightOfLabel2 );
			g2.fillRect( Left2, bottom2, widthOfBar, numUnits2);
		}


		if(percentOfTails>0)
		{
			g2.setColor(colorbar3);
			bar3.draw(g2);
			g2.drawString(label3,(Left3 - (widthOfLabel3/2)) + (widthOfBar/2), heightofComponent-heightOfLabel3 );
			g2.fillRect(Left3, bottom3 , widthOfBar, numUnits3);
		}

	}




}


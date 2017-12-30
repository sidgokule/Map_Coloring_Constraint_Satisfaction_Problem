package main;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author Siddhant
 *
 */
public class MinConflicts_RandomRestart {
	
	/**
	 * Method to randomly assign colors to all regions of map; Random restart
	 * @param regionMap
	 * @param colors
	 */
	public void randomRestart(Map<Integer,Region>regionMap,List<String>colors)
	{
		for(Map.Entry<Integer, Region>entry : regionMap.entrySet())
		{
			Random rand = new Random();
			int colorid=rand.nextInt(4);
			String tempColor = colors.get(colorid); 
			Region tempRegion = new Region();
			tempRegion = entry.getValue();
			tempRegion.setColor(tempColor);
		}
	}
}

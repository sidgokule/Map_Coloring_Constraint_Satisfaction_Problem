package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Siddhant
 *
 */
public class CalculateConflicts {
	
	/**
	 * Method to calculate the total conflicts / constraint violations in current map
	 * @param regionMap
	 * @return
	 */
	public int calculateConflicts(HashMap<Integer, Region>regionMap)
	{
		for(Map.Entry<Integer,Region> entry : regionMap.entrySet())
		{
			Region tempRegion = entry.getValue();
			tempRegion.setChecked(false);
		}
		int conflicts = 0;
		for(Map.Entry<Integer,Region> entry : regionMap.entrySet())
		{
			Region tempRegion = entry.getValue();
			String tempColor = tempRegion.getColor();
			List<Integer> tempNeighborList = tempRegion.getNeighbors();
			
			for(Integer current : tempNeighborList)
			{
				Region currentNeighbor = regionMap.get(current);
				String neighborColor = currentNeighbor.getColor();
				if(!currentNeighbor.isChecked&&tempColor.equalsIgnoreCase(neighborColor))
					conflicts++;
			}
			tempRegion.setChecked(true);
		}
		
		
		return conflicts;
	}

}

package main;

import java.util.Map;
/**
 * 
 * @author Siddhant
 *
 */
public class GetNextRegionToColor {
	
	/**
	 * Method to choose the next neighbor for coloring 
	 * @param regionMap
	 * @return Region
	 */
	public Region getNextRegionToColor(Map<Integer, Region>regionMap)
	{
		Region nextRegion = new Region();
		int nColor = 0;
		int i=0;
		Region firstRegion = new Region();
		Region tempRegion = new Region();
		for(Map.Entry<Integer, Region>entry: regionMap.entrySet())
		{
			if (i == 0)
			{
			firstRegion = entry.getValue();
			nColor = firstRegion.getPermissibleColors().size();
			i++;
			continue;
			}
			tempRegion = entry.getValue();
			if (tempRegion.isColored)
				continue;
			int tempSize = tempRegion.getPermissibleColors().size();
			if(tempSize<=nColor)
			{
				nColor=tempSize;
				nextRegion = tempRegion;
				continue;
			}
				
			
		}
		if(nextRegion.getId()==0)
		{
				nextRegion=firstRegion;
				if(firstRegion.isColored)
					nextRegion = new Region();

		}
			
	//System.out.println("Min color = "+ nColor+ " and region is : "+nextRegion.getId());
		return nextRegion;
	}

}

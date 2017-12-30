package main;

import java.util.List;

public class CheckConstraints {

	public boolean checkConstraints(String color, Region region, List<Region> regionsList) {
		
		List<Integer> neighborList = region.getNeighbors();
		Region tempRegion = new Region();
		GetRegionDetails getRegionDetails = new GetRegionDetails();
		
		for(Integer tempNeighbor: neighborList)
		{	
			if(!tempRegion.isColored)
			{
			tempRegion = getRegionDetails.getRegionDetails(tempNeighbor, regionsList);
			if(tempRegion==null)
				return true;
			if(tempRegion.getColor().equalsIgnoreCase(color))
				return false;
			}
		}
		return true;
	}
}

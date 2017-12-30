package main;

import java.util.List;

public class GetRegionDetails {

	public Region	getRegionDetails(int id, List<Region>regionsList)
	{
		Region region = new Region();
		for(Region tempRegion:regionsList)
		{
			int tempId;
			tempId = tempRegion.getId();
			if (tempId == id)
			{
				region.id = tempRegion.id;
				region.color = tempRegion.getColor();
				region.neighbors = tempRegion.neighbors;
				return region;
			}
		}
		return null;
	}
}

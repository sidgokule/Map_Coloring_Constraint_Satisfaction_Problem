package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Siddhant
 *
 */
public class MRVSolutionClass {
	
	/**
	 * Method to solve CSP using MRV
	 * @param map
	 * @param n
	 * @param colors
	 */
	public void CSP_Using_MRV(int[][] map, int n , List<String>colors) {
		
		System.out.println("\n\nProcessing MRV solution...");
		HashMap<Integer,List<Integer>> neighbors = new HashMap<>();
		List<Region>regionsList = new ArrayList<>();
		HashMap<Integer, Region> regionMap = new HashMap<>();
		
		for(int i=0;i<n;i++)
		{	
			Region region = new Region(i);
			List<Integer> temp = new ArrayList<>();
			for(int j=0;j<n;j++)
			{
				if(map[i][j]==1)
				{
					temp.add(j+1);
				}
			}
			neighbors.put(i+1, temp);
			region.setId(i+1);
			region.setNeighbors(i+1,temp);
			region.setNumberOfPossibleColors(colors.size());
			List<String>tempList = new ArrayList<String>(colors);
			region.setPermissibleColors(tempList);
			regionsList.add(region);
			regionMap.put(region.getId(), region);
		}
		List<Region>regionsToColor=  new ArrayList<>();
		regionsToColor = new ArrayList<Region> (regionsList);
		int maxNumberOfNeighbors=0;
		Region currentRegion = new Region();
		
		//Choose region with max neighbors for first coloring
		for(Region region: regionsList)
		{	
			int tempNeighbors=0;
			System.out.println("Region "+region.getId()+" has neighbors "+region.getNeighbors());
			tempNeighbors = region.getNeighbors().size();
			if(tempNeighbors>maxNumberOfNeighbors)
			{
				maxNumberOfNeighbors = tempNeighbors;
				currentRegion = region;
			}
		}
		
		currentRegion.setColor(colors.get(0));
		currentRegion.setColored(true);
		mapfor:
		for(Map.Entry<Integer, Region> entry : regionMap.entrySet())
		{
			if(entry.getKey()==currentRegion.getId())
			{
			Region tempRegion = entry.getValue();
			List<Integer>tempneighbors = tempRegion.getNeighbors();
			for(Integer currentNeighbourId : tempneighbors)
			{
				Region currentNeighbor = regionMap.get(currentNeighbourId);
				List<String> currentNeighbourColorList= currentNeighbor.getPermissibleColors();
				currentNeighbourColorList.remove(currentRegion.getColor());
				currentNeighbor.setNumberOfPossibleColors(currentNeighbor.getNumberOfPossibleColors()-1);
			}
			break mapfor;

			}
		}
		regionsToColor.remove(currentRegion);
		GetNextRegionToColor getNext = new GetNextRegionToColor();
		Region tempRegion = getNext.getNextRegionToColor(regionMap);
		while(regionsToColor.size()!=0)
		{
			if(tempRegion.getPermissibleColors().size()==0)
			{
				System.out.println("CSP Unsolvable as "+tempRegion.getId()+" has no color left!!!!!");
				System.exit(0);
			}
			String tempColor= tempRegion.getPermissibleColors().get(0);
			tempRegion.setColor(tempColor);
			tempRegion.setColored(true);
			regionsToColor.remove(tempRegion);
			List<Integer>tempneighbors = tempRegion.getNeighbors();
			for(Integer currentNeighbourId : tempneighbors)
			{
				Region currentNeighbor = regionMap.get(currentNeighbourId);
				if(!currentNeighbor.isColored)
				{
				List<String> currentNeighbourColorList= currentNeighbor.getPermissibleColors();
				currentNeighbourColorList.remove(tempRegion.getColor());
				currentNeighbor.setNumberOfPossibleColors(currentNeighbor.getNumberOfPossibleColors()-1);
				}
			}
			tempRegion = getNext.getNextRegionToColor(regionMap);
			if(tempRegion.getId()==0)
			{
				for(Map.Entry<Integer, Region> entry : regionMap.entrySet())
				{
					Region temp = entry.getValue();
					if(temp.isColored)
						continue;
					tempRegion=temp;
				}
			}
			
		}
		
		//For printing final map
		System.out.println("\n\nFollowing are colors assigned using MRV: \n");
		for(Map.Entry<Integer, Region> entry : regionMap.entrySet())
		{
			Region finalRegion = entry.getValue();
			finalRegion.getPermissibleColors();
			String finalColor= finalRegion.getColor();
			System.out.println("Region "+finalRegion.getId()+" has color "+ finalColor.toUpperCase());
		}
			

	}

}

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
public class MinConflictsSolutionClass {
	
	/**
	 * Method to solve CSP using min-conflicts algorithm
	 * @param map
	 * @param colors
	 * @param n
	 */
	public void CSP_Using_MinConflicts(int[][]map, List<String>colors, int n)
	{

		System.out.println("\n\nProecssing Min-Conflicts solution");
		HashMap<Integer, Region> regionMap = new HashMap<>();
		HashMap<Integer,List<Integer>> neighbors = new HashMap<>();
		List<Region>regionsList = new ArrayList<>();
		int maxRestarts = 50000;
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
		
		
		
		MinConflicts_RandomRestart randomRestart = new MinConflicts_RandomRestart();
		
		//Randomly assign values to regions
		randomRestart.randomRestart(regionMap, colors);
		

		int conflicts = 0;
		int minHeuristicValue = 0;
		CalculateConflicts getConflicts = new CalculateConflicts();
		conflicts= getConflicts.calculateConflicts(regionMap);
		minHeuristicValue = conflicts;
		String tempColorWithMinHeuristics;
		//System.out.println("Initial minHeursisticValue = "+minHeuristicValue);
		int numberOfRestarts = 0;
		outer:
		while(conflicts!=0)
		{
			for(Map.Entry<Integer,Region> entry : regionMap.entrySet())
			{
				Region tempRegion = entry.getValue();
				tempColorWithMinHeuristics = tempRegion.getColor();
				for(String tempColor : colors)
				{
					tempRegion.setColor(tempColor);
					conflicts = getConflicts.calculateConflicts(regionMap);
	
					if(conflicts<minHeuristicValue)
					{
						if(conflicts==0)
						{
							System.out.println("\nThis is complete solution using MIN-CONFLICTS\n");
							break outer;
						}
						minHeuristicValue=conflicts;
						tempColorWithMinHeuristics = tempRegion.getColor();
					}
				}
				tempRegion.setColor(tempColorWithMinHeuristics);
			}
			if(conflicts!=0)
			{
				randomRestart.randomRestart(regionMap, colors);
				numberOfRestarts++;
			}
				
			if(numberOfRestarts>maxRestarts)
				{
				System.out.println("\nMax permissible restarts performed and still solution not found please try again, following is partial solution");
				break outer;
				}
		}
		
		for(Map.Entry<Integer,Region> entry : regionMap.entrySet())
		{
			Region tempRegion = entry.getValue();
			System.out.println("Region "+tempRegion.id+" has neighbors "+tempRegion.getNeighbors());

		}
		
		System.out.println("\n\nFollowing are colors obtained using Min-conflicts:\n");
		for(Map.Entry<Integer,Region> entry : regionMap.entrySet())
		{
			Region tempRegion = entry.getValue();
			System.out.println("Region "+tempRegion.getId()+" has color "+tempRegion.getColor().toUpperCase());
			
		}
		System.out.println("Restarts required = "+numberOfRestarts);
	
	}
}

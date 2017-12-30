package main;

import java.util.Scanner;
 
/**
 * 
 * @author Siddhant
 *
 */
public class UserInput {
	
	/**
	 * Method to take input of the map from the user
	 * @param n
	 * @return 2D array of map representation
	 */
	public int[][] getUserInput(int n)
	{
		int [][]map = new int[n][n];
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int numberOfRegionLinks=0;
		boolean flag = false;
		while(!flag)
		{
			System.out.println("Enter total neigbors in map: ");
			numberOfRegionLinks = in.nextInt();
			if(numberOfRegionLinks>((n*(n-1))/2))
			{
				System.out.println("Thats more than max possible links the graph with given nodes can have.Please enter correct number of regions");
			}
			else
			flag = true;
		}
		flag=false;
		for(int i =0 ;i <numberOfRegionLinks;i++)
		{
				
			int region;
			int neighbor;
			System.out.println("Enter region-neighbor pair "+(i+1));
			System.out.println("Enter region id (1 to "+n+"): ");
			region = in.nextInt();
			System.out.println("Enter it's neighbor id (1 to "+n+"): ");
			neighbor=in.nextInt();
			if(region != neighbor)
			{
				map[region-1][neighbor-1]=1;
				map[neighbor-1][region-1]=1;	
			}
			else
			{
			System.out.println("A region is its own neighbor!!!");
			}
			
		}
		
		return map;
	}

}

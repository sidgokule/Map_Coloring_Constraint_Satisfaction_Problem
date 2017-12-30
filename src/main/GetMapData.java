package main;

import java.util.Random;
/**
 * 
 * @author Siddhant
 *
 */
public class GetMapData {
	
	/**
	 * Method to generate random map and clean it if necessary(if a spatial map is generated) 
	 * @param n
	 * @return
	 */
	public int[][] getMapData(int n){
		int[][] map =new int [n][n];
		int links=0;
		boolean flag = false;
		int numberOfNeighbors = 0;
		boolean numberOfNeighborsExceeded=true;
		while(flag!=true)
		{
			links=0;
			map = generateData(n); 
			for(int i=0;i<n;i++)
			{
				for(int j=i+1;j<n;j++)
				{
					if(map[i][j]==1)
						links++;
				}
			}
			
			if(links < ( ( n * ( n-1 ))/2) )
					flag=true;
		}
		
		while(numberOfNeighborsExceeded!=false)
		{
			outer:
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(map[i][j]==1)
						numberOfNeighbors++;
					if(numberOfNeighbors>3)
					{
						numberOfNeighborsExceeded=true;
						//map = cleanData(map,n);
						break outer;
					}
				}
				numberOfNeighbors=0;
			}
			
			numberOfNeighborsExceeded=false;

		}

		return map;
	}
	
	/**
	 * Method to generate random map data
	 * @param n
	 * @return 2D array
	 */
	 public int[][] generateData(int n)
	 {
		 int[][] tempMap = new int[n][n];
		 for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(i==j)
						tempMap[i][j]=0;
					else
					{
						Random rand = new Random();
						tempMap[i][j]=rand.nextInt(2);
						tempMap[j][i]=tempMap[i][j];
					}
				}
			}
		 
		 return tempMap;
	 }
	 
	 /**
		 * Method to clean map data it if necessary(if a spatial map is generated) 
		 * @param n
		 * @return 2D array
		 */
	 public int [][] cleanData( int n)
	 {
		 int [][] tempMap = new int[n][n];
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<n;j++)
			 {
				 tempMap[i][j]=-1;
				 if(i==j)
					 tempMap[i][j]=0;
			 }
		 }
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<n;j++)
			 {
				if(tempMap[i][j]==-1)
				{
					if(j==i-4 || j==i-3||j==i-2||j==i-1||j==i+1||j==i+2||j==i+3||j==i+4)
					{
						Random rand = new Random();
						tempMap[i][j]=rand.nextInt(2);
						tempMap[j][i]=tempMap[i][j];
					}
					else
						tempMap[i][j]=0;
				}
				
			 }
		 }
		 return tempMap;
	 }
}

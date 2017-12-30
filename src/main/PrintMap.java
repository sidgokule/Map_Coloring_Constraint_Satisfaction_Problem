package main;

/**
 * 
 * @author Siddhant
 *
 */
public class PrintMap {
	
	/**
	 * Method to print a map representation in 2D array format
	 * @param map
	 */
	public void printMap(int map[][]) {
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map.length;j++)
			{
				System.out.print(map[i][j]+" ");
			}
			System.out.println("");
		}
	}

}

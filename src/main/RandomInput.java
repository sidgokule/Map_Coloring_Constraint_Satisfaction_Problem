package main;

/**
 * 
 * @author Siddhant
 *
 */
public class RandomInput {

	/**
	 * Method to randomly generate a map for the user with specified number of regions
	 * @param n
	 * @return
	 */
	public int[][] getRandomInput(int n)
	{
		int [][]map = new int[n][n];
		GetMapData getMap = new GetMapData();
		map = getMap.cleanData(n);
		
		return map;
	}
}

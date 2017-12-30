Steps to run the program:

1) Unzip and import the project(CSP_Map_Coloring) in Eclipse (or any IDE that runs JAVA)

2) Right click on the project-> Run As -> Java Application

3) If option is not there right click on main.java-> Run As -> Java Application

4) In the console, enter the number of regions present in map you want to input.

5) Type 1 or 2 depending on your choice to input the map or generate it randomly for you and press ENTER.

6) If you want to input map and you chose 1, you will be prompted for total neighbors in your map. Enter the total number of neighbors OR basically the number of links 
   in constraint graph representation of your map and press ENTER.Note that this can be only less than n*(n-1)/2 to make a flat map and has be handled in program.

7) Now enter the region id who has neighbor press ENTER and input its neighbor id and press ENTER ( both should  be between 1 to n and not 0 to n-1).NOTE that you shouldn't enter consider region as its own neighbor, so the region id and neighbor id should always be distinct.

8) This will repeat till your number of links.

9) You will now be prompted to input choice of algorithm which you want to run. Type 1,2 or 3 choice based on your choice and hit ENTER.
   If you want to compare both algorithms for same input enter 3.

10) Solution will now displayed in "Region id has color RED" format. Time required for algorithm will also be displayed in milliseconds.

Note:
1. Random maps can be sometimes unsolvable if a spatial map is generated randomly, although it has been handled to a certain extent, hence it is 
recommended to enter the map which is a flat 2D map

2. For choosing options please enter only the provided choices, any other alphabet key press has not yet been handled and can cause abrupt program termination

3. For executables go to executables folder and double click CSP_Map_Coloring batch file to run.
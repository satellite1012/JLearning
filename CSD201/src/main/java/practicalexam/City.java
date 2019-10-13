package practicalexam;

import java.util.StringTokenizer;
import java.io.*;

public class City {
	// Arrays to keep track of info. related to each city
	public String[] cityName;
	private String[] cityState;
	private int[] cityLat;
	private int[] cityLong;
	private int[] cityPop;

	// 2-D array to keep track of pairwise distances between cities
	public int[][] distances;

	// boolean 1-D array to keep track of selected cities
	// private boolean[] currentCities;

	// boolean 2-D array to keep track of selected edges
	private boolean[][] currentEdges;

	// number of cities
	private static int numCities = 128;

	public City() {
		// Allotting the space for each 1-D array
		cityName = new String[numCities];
		cityState = new String[numCities];
		cityLat = new int[numCities];
		cityLong = new int[numCities];
		cityPop = new int[numCities];
		// currentCities = new boolean[numCities];

		// Allocate space for each 2-D array. These arrays have 0 elements in row 0,
		// 1 element in row 1, 2 elements in row 2, etc.
		distances = new int[numCities][];
		currentEdges = new boolean[numCities][];

		for (int i = 0; i < numCities; i++) {
			distances[i] = new int[i];
			currentEdges[i] = new boolean[i];
		}

		try {

			// Construct a buffered reader object and connect it to the files "miles.dat"
			BufferedReader in = new BufferedReader(new FileReader("miles.dat"));

			// A counter that keeps track of the index of the current city being read
			int cityNumber = 0;

			// While-loop for reading in data from "miles.dat." At the beginning of the
			// while-loop
			// the expectation is that we'll be reading a line containing the city name.
			// Instead,
			// if we encounter a line that starts with "*" then we skip to the next line
			while (cityNumber < numCities) {
				// Read in a line
				String line = in.readLine();

				// Skip the rest of the loop if line starts with a "*"
				if (line.charAt(0) == '*')
					continue;

				// Otherwise tokenize the line
				StringTokenizer tokenizedLine = new StringTokenizer(line, ",[]");

				// Putting actual data into correct position in the array
				cityName[cityNumber] = tokenizedLine.nextToken();
				cityState[cityNumber] = (tokenizedLine.nextToken()).trim(); // trim() gets rid of leading/trailing
																			// blanks
				cityLat[cityNumber] = Integer.parseInt(tokenizedLine.nextToken());
				cityLong[cityNumber] = Integer.parseInt(tokenizedLine.nextToken());
				cityPop[cityNumber] = Integer.parseInt(tokenizedLine.nextToken());

				// while loop to put distances in the array; this may need to read several lines
				int mileNumber = 0;
				while (mileNumber < cityNumber) {
					// Read a mileage line and tokenize it
					String mileage = in.readLine();
					StringTokenizer tokenizedMileage = new StringTokenizer(mileage, " ");

					// Read all the mileage data in this line into row cityNumber; increment
					// mileNumber after each read
					while (tokenizedMileage.hasMoreTokens()) {
						distances[cityNumber][cityNumber - mileNumber - 1] = Integer
								.parseInt(tokenizedMileage.nextToken());
						mileNumber++;
					}

				} // end of while reading distances

				cityNumber++;
			} // end of while reading cities
			in.close();

		} // end of try
		catch (IOException e) {
			System.out.println("File not found.");
		}

	} // end of City() constructor

	// A simple getIndex method to help test the constructor
	int getIndex(String city, String state) {

		int location;
		for (location = 0; location < numCities; location++)
			if ((cityName[location].equals(city)) && (cityState[location].equals(state)))
				return location;

		return -1;

	}

	// Print information about a city, given a city index
	void printCityInfo(int index) {
		System.out.println(cityName[index] + " " + cityState[index] + " " + cityLat[index] + " " + cityLong[index] + " "
				+ cityPop[index]);
	}

	// Print distance information between a given pair of cities
	void printDistanceInfo(int i, int j) {
		if (i < j)
			System.out.println(distances[j][i]);
		else
			System.out.println(distances[i][j]);
	}
	
	private myweightedGraph graph = null;
	public myweightedGraph toWeightedGraph()
	{
		if(graph != null) return graph;

		graph = new myweightedGraph(numCities);

		for(int i = 0; i<numCities; i++)
		{
			graph.addVertex(cityName[i]);
			
			for(int j = 0; j<i; j++)
			{
				graph.addEdge(cityName[i], cityName[j], distances[i][j]);
			}
		}
		return graph;
	}

	// Main method
	public static void main(String[] args) {
		City newCity = new City();
		int i, j;

		newCity.printCityInfo(i = newCity.getIndex("Wilmington", "DE"));
		newCity.printCityInfo(j = newCity.getIndex("Uniontown", "PA"));
		newCity.printDistanceInfo(i, j);

		newCity.printCityInfo(i = newCity.getIndex("Stockton", "CA"));
		newCity.printCityInfo(j = newCity.getIndex("Seminole", "OK"));
		newCity.printDistanceInfo(i, j);

		newCity.printCityInfo(i = newCity.getIndex("Roanoke", "VA"));
		newCity.printCityInfo(j = newCity.getIndex("Salisbury", "MD"));
		newCity.printDistanceInfo(i, j);

	}

}

package practicalexam;

// import java.util.Arrays;

public class CityTester {
    // Main method
    public static void main(String[] args) {
        City newCity = new City();

        myweightedGraph graph = newCity.toWeightedGraph();

        // for (String e : graph.getSortedEdges(0)) {
        //     System.out.println(e);
        // }

        for (int e : graph.MST()) {
            if(e!=-1)
                System.out.println(newCity.cityName[e] + " ");
            
        }

        // int i, j;

        // newCity.printCityInfo(i = newCity.getIndex("Wilmington", "DE"));
        // newCity.printCityInfo(j = newCity.getIndex("Uniontown", "PA"));
        // newCity.printDistanceInfo(i, j);

        // newCity.printCityInfo(i = newCity.getIndex("Stockton", "CA"));
        // newCity.printCityInfo(j = newCity.getIndex("Seminole", "OK"));
        // newCity.printDistanceInfo(i, j);

        // newCity.printCityInfo(i = newCity.getIndex("Roanoke", "VA"));
        // newCity.printCityInfo(j = newCity.getIndex("Salisbury", "MD"));
        // newCity.printDistanceInfo(i, j);

        // for (int[] ele : newCity.distances)
        // {
        // System.out.println(Arrays.toString(ele));
        // }
    }
}
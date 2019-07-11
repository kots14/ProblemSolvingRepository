// Problem: https://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/
public class MinimumCostToReachDestinationInTrain {
    static int mctrdt(int[][] cost, int source, int destination) {
        if(source == destination || source + 1 == destination)
            return cost[source][destination];
        
        int min = cost[source][destination];
        for(int i = source + 1; i < destination; i++) {
            int c = mctrdt(cost, i, destination) + mctrdt(cost, source, i);
            min = Math.min(min, c);
        }
        return min;
    }
    public static void main(String[] main) {
        int mv = Integer.MAX_VALUE;
        int cost[][] = { {0, 15, 80, 90}, 
                      {mv, 0, 40, 50}, 
                      {mv, mv, 0, 70}, 
                      {mv, mv, mv, 0} 
                    }; 
        System.out.println("To reach station "+ cost.length + " min cost : "+mctrdt(cost, 0, cost.length - 1)); 
    }
}
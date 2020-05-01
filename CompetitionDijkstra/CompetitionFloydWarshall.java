/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class CompetitionFloydWarshall {
    public final double INFINITY = Double.POSITIVE_INFINITY;
    public static int speedA, speedB, speedC, numIntersections, numStreets;
    public double[][] paths;

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA,       sB, sC: speeds for 3 contestants
     */
    CompetitionFloydWarshall(String filename, int sA, int sB, int sC) {
        File cityFile;
        if (filename != null) {
            cityFile = new File(filename);
        }
        else {
            cityFile = null;
        }

        this.speedA = sA;
        this.speedB = sB;
        this.speedC = sC;
        try {
            if(cityFile != null) {
                BufferedReader in = new BufferedReader(new FileReader(cityFile));
                String temp = in.readLine();
                this.numIntersections = Integer.parseInt(temp);
                temp = in.readLine();
                this.numStreets = Integer.parseInt(temp);
                paths = new double[numIntersections][numIntersections];
                for (double[] row : paths) {
                    Arrays.fill(row, INFINITY);
                }
                for(int i = 0; i < numIntersections; i++)
                {
                    paths[i][i] = 0;
                }
                for (int i = 0; i < numStreets; i++) {
                    temp = in.readLine();
                    String parse[] = temp.split("\\s+");
                    int source = Integer.parseInt(parse[0]);
                    int dest = Integer.parseInt(parse[1]);
                    Double length = Double.parseDouble(parse[2]);
                    paths[source][dest] = length;
                }
                in.close();
            }
            else{
                this.paths = null;
            }
        } catch (Exception e) {
            this.paths = null;
        }
        if(paths != null)
        {
            for (int k = 0; k < numIntersections; k++)
            {
                for (int i = 0; i < numIntersections; i++)
                {
                    for (int j = 0; j < numIntersections; j++)
                    {
                        if (paths[i][k] + paths[k][j] < paths[i][j])
                        {
                            paths[i][j] = paths[i][k] + paths[k][j];
                        }
                    }
                }
            }
        }
    }

    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition() {
        if(numIntersections == 0) {
            return -1;
        }
        if (speedA < 50 || speedB < 50 || speedC < 50 || speedA > 100 || speedB > 100 || speedC > 100)
        {
            return -1;
        }
        double minimumTime;
        double longestPath = -1;
        for(int i = 0; i < paths.length; i++)
        {
            for(int j = 0; j < paths.length; j++)
            {
             if(paths[i][j] > longestPath)
             {
                 longestPath = paths[i][j];
             }
            }
        }
        if(longestPath == INFINITY)
        {
            return -1;
        }
        int slowest = findSlowest();
        minimumTime = (longestPath*1000)/slowest;
        return (int) (Math.ceil(minimumTime));
    }

    public int findSlowest() {
        if(speedA < speedB && speedA < speedC)
        {
            return speedA;
        }
        else if(speedB < speedA && speedB < speedC)
        {
            return speedB;
        }
        return speedC;
    }
}
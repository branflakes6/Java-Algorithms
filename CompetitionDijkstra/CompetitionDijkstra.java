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
 * This class implements the competition using Dijkstra's algorithm
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.ArrayList;

class Street{
    int dest;
    double dist;
    Street(int dest, double dist)
    {
        this.dest = dest;
        this.dist = dist;
    }
}
class Intersection{
    ArrayList<Street> streets;
    Intersection(){
        streets = new ArrayList<Street>();
    }
}

public class CompetitionDijkstra {
    public static int speedA, speedB, speedC, numIntersections, numStreets;
    public Intersection[] paths;
    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     */
    CompetitionDijkstra (String filename, int sA, int sB, int sC){
        File cityFile;
        if (filename != null)
        {
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
                this.paths = new Intersection[numIntersections];
                for(int i=0; i<paths.length;i++)
                {
                    paths[i] = new Intersection();
                }

                for (int i = 0; i < numStreets; i++) {
                    temp = in.readLine();
                    String parse[] = temp.split("\\s+");
                    int source = Integer.parseInt(parse[0]);
                    int dest = Integer.parseInt(parse[1]);
                    Double length = Double.parseDouble(parse[2]);
                    paths[source].streets.add(new Street(dest,length));
                }
                in.close();
            }
            else{
                this.paths = null;
            }
        } catch (Exception e) {
            this.paths = new Intersection[0];
        }
    }
    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition() {
        if (speedA < 50 || speedB < 50 || speedC < 50 || speedA > 100 || speedB > 100 || speedC > 100) {
            return -1;
        }
        if(numIntersections == 0)
        {
            return -1;
        }
        double minimumTime = -1;
        int slowest = findSlowest();
        for (int index = 0; index < paths.length; index++)
        {
            double[] distance = new double[paths.length];
            int edge[] = new int[paths.length];
            ArrayList<Integer> queue = new ArrayList<>();
            ArrayList<Integer> visited = new ArrayList<>();
            queue.add(index);
            for (int i = 0; i < edge.length; i++) {
                edge[i] = -1;
                distance[i] = -1;
            }
            distance[index] = 0;
            edge[index] = index;
            while (!queue.isEmpty()) {
                int minIndex = getMin(queue, distance);
                int intersection = queue.remove(minIndex);
                Intersection currentIntersection = paths[intersection];
                for (int i = 0; i < currentIntersection.streets.size(); i++) {
                    Street currentStreet = currentIntersection.streets.get(i);
                    if (currentStreet.dist + distance[intersection] < distance[currentStreet.dest] || distance[currentStreet.dest] == -1) {
                        distance[currentStreet.dest] = currentStreet.dist + distance[intersection];
                        edge[currentStreet.dest] = intersection;
                    }
                    if (!visited.contains(currentStreet.dest) && !queue.contains(currentStreet.dest))
                        queue.add(currentStreet.dest);
                }
                visited.add(intersection);
            }
            Arrays.sort(distance);
            double maxDist = distance[distance.length-1];
            boolean valid = true;
            for(int i=0; i <edge.length; i++)
            {
                if(edge[i] == -1)
                {
                    valid = false;
                }
            }
            if(minimumTime == -1)
            {
                minimumTime = (maxDist *1000)/slowest;
            }
            else if(!valid)
            {
                return -1;
            }
            else
                minimumTime = Math.max(minimumTime, (maxDist *1000)/slowest);
        }
        return (int)(Math.ceil(minimumTime)) ;
    }

    private int getMin(ArrayList<Integer> queue, double[] distTo)
    {
        int min = 0;
        for(int i=0;i<queue.size();i++)
        {
            if(distTo[queue.get(min)] > distTo[queue.get(i)])
            {
                min = i;
            }
        }
        return min;
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
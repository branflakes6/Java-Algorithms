import org.junit.Test;
import static org.junit.Assert.assertEquals;
/*
 Dijkstra is a greedy algorithm that finds the shortest path of a graph from a given source node.
 My implementation of this algorithm uses an array of Intersections each of which has its own arrayList. This is easy to use and access and does not negetively affect the run time of
 Dijkstra. It also made it easy to use a Priority Queue which means it has a time complexity of O(E * log(V)). I chose this as you can also implement Dijkstra with an Array but this would give you a
 O(V^2) run time. Dijkstra is very efficient for large data sets but has the draw back of you cant use it to find all possible paths only the fastest ones.

 FloydWarshall compares all possible paths through all possible vertices of the graph and has a time complexity of O(V^3) even if there
 is V^2 vertices. This is very inefficient however it determines every possible pathway through the graph so it can be useful if you want to know all possible paths if you modify it.
 FloydWarshall is generally faster for small numbers of vertices than Dijkstra and so has some advantages in this scenario, however Dijkstra outperforms its greatly at larger inputs.
 My implementation of FloysWarshall uses a 2D Array to represent the graph of the City, each index of the Array represents a connection between two Vertices, from 0,0 to V,V. The algorithm then loops through this
 graph, testing every possible combination of connections between all vertices. If a shorter path is found it updates the graph with that value. I felt this was the best data structure to use as it was the most
 straight forward and as the algorithm itself has a running time of O(V^3) it doesnt matter if you have to do nested for loops.

 Dijkstra also cannot deal with negative weights while FloydMarshall can. This should not be relevant in this scenario as we are dealing with distances between two points which cannot be negative.
 */
public class CompetitionTests {

    @Test

    public void testDijkstraConstructor() {

        CompetitionDijkstra test = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 50);
        assertEquals(38, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("tinyEWD.txt", 60, 70, 80);
        assertEquals(31, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("tinyEWD.txt", 20, 50, 50);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("tinyEWD.txt", 50, 20, 50);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 20);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("tinyEWD.txt", 50, 110, 50);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("tinyEWD.txt", 110, 50, 50);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 110);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("tinyEWD.txt", 80, 110, 90);
        assertEquals(test.timeRequiredforCompetition(), -1);

        test = new CompetitionDijkstra("tinyEWD.txt", 110, 99, 90);
        assertEquals(test.timeRequiredforCompetition(), -1);

        test = new CompetitionDijkstra("tinyEWD.txt", 98, 99, 110);
        assertEquals(test.timeRequiredforCompetition(), -1);

        test = new CompetitionDijkstra("tinyEWD.txt", 50, 60, 70);
        assertEquals(38, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("tinyEWD.txt", 60, 50, 70);
        assertEquals(38, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("tinyEWD.txt", 70, 60, 50);
        assertEquals(38, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("input-J.txt", 50, 50, 50);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra(null,50,50,50);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("input-A.txt", 50, 50, 50);
        assertEquals(-1, test.timeRequiredforCompetition());
    }

    @Test
    public void testFWConstructor() {
        CompetitionFloydWarshall test = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 50);
        assertEquals(38, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("tinyEWD.txt", 60, 70, 80);
        assertEquals(31, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("tinyEWD.txt", 20, 50, 50);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("tinyEWD.txt", 50, 20, 50);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 20);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("tinyEWD.txt", 50, 110, 50);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("tinyEWD.txt", 110, 50, 50);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 110);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("tinyEWD.txt", 80, 110, 90);
        assertEquals(test.timeRequiredforCompetition(), -1);

        test = new CompetitionFloydWarshall("tinyEWD.txt", 110, 99, 90);
        assertEquals(test.timeRequiredforCompetition(), -1);

        test = new CompetitionFloydWarshall("tinyEWD.txt", 98, 99, 110);
        assertEquals(test.timeRequiredforCompetition(), -1);

        test = new CompetitionFloydWarshall("tinyEWD.txt", 50, 60, 70);
        assertEquals(38, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("tinyEWD.txt", 60, 50, 70);
        assertEquals(38, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("tinyEWD.txt", 70, 60, 50);
        assertEquals(38, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("input-J.txt", 50, 50, 50);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall(null,50,50,50);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("input-A.txt", 50, 50, 50);
        assertEquals(-1, test.timeRequiredforCompetition());
    }

    
}

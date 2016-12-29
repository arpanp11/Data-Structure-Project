import java.util.*;

public class Dijkstra {

    /**
     * This method computes the shortest path using Dijkstra algorithm using
     * priority queue
     *
     * @param source vertex
     */
    public static void computePaths(Vertex source) {
        source.minimumDist = 0.;
        // priority queue
        PriorityQueue<Vertex> vertexPQ = new PriorityQueue<Vertex>();
        vertexPQ.add(source);// add source to queue

        while (!vertexPQ.isEmpty()) {// while mu queue is not empty
            Vertex u = vertexPQ.poll();

            // Visit each edge of the vertex
            for (Edge edge : u.adjacentEdges) {// all its edges
                Vertex v = edge.targetVetex;
                double weight = edge.weight;

                // check that all edges e = u->v satisfy condition, distTo[v] ==
                // distTo[u] + e.weight()
                double newDistance = u.minimumDist + weight;
                if (newDistance < v.minimumDist) {
                    vertexPQ.remove(v);
                    v.minimumDist = newDistance;
                    v.predVertex = u;
                    vertexPQ.add(v);// update vertex with minimum distance
                }

            }
        }
    }

    /**
     * this method backtrack the path to get the path
     *
     * @param destination
     * @return list of path
     */
    public static List<Vertex> getShortestPathTo(Vertex destination) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = destination; vertex != null; vertex = vertex.predVertex) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }
}
